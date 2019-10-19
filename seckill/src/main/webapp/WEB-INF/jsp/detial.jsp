<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <title>秒杀详情页</title>
      <%@include file="common/head.jsp" %>
      <script type="text/javascript">
      var seckill = {
    			//封装秒杀相关ajax的URL
    			URL:{
    				now : function(){
    					return '/seckill/time/now';
    				},
    				exposer: function(seckillId){
    					return '/seckill/'+seckillId+'/exposer';
    				},
    				execution: function(seckillId,md5){
    					return '/seckill/' + seckillId +'/' + md5 + '/execute';
    				}
    			},
    			//验证手机号
    			validatePhone: function(phone){
    					
	    				if(phone && phone.length == 11 && !isNaN(phone)){
	    					return true;
	   					}else{
	  						return false;
	   					}
    				},
    			handelseckill: function(seckillId,node){
    				//执行秒杀
    				node.hide().html('<button class="btn btn-primary btn-lg" id="killBtn">开始秒杀</button>')
    				$.post(seckill.URL.exposer(seckillId),{},function(result){
    					//再回调函数中，执行交互流程
    					if(result && result['success']){
    						var exposer = result['data'];
    						if(exposer['exposed']){
    							//开启秒杀
    							//获取秒杀地址
    							var md5 = exposer['md5']
    							var killUrl = seckill.URL.execution(seckillId,md5);
    							console.log('killURL='+killUrl);
    							
    							//绑定一次绑定事件，防止用户连续点击
    							$('#killBtn').one('click',function(){
    								//执行秒杀请求的操作
    								//1。禁用按钮 2. 
    								$(this).addClass('disable')
    								//2.发送秒杀请求,执行秒杀
    								$.post(killUrl,{},function(result){
    									if(result && result['success']){
    										var killResult = result['data'];
    										var status = killResult['status'];
    										var statusInfo = killResult['statusInfo'];
    										//显示秒杀结果
    										node.html('<span class="label label-success">'+ statusInfo +'</span>')
    									}
    								})
    							});
    							node.show();
    						}else{
    							//未开启秒杀
    							var now = exposer['now'];
    							var start = exposer['start'];
    							var end = exposer['end'];
    							//继续执倒计时页面
    							seckill.countdown(seckillId,now,start,end);
    						}
    					}else{
    						console.log('result:'+result);
    					}
    					
    				});
    				
    			},
    			countdown: function(seckillId,nowTime,startTime,endTime){
    				
    				var seckillBox = $('#seckill-box');
    				//时间判断：
    				if(nowTime > endTime){
    					//秒杀结束
    					seckillBox.html('秒杀结束')
    				}else if(nowTime < startTime){
    					//秒杀未开启	计时时间绑定
    					var killTime = new Date(startTime + 1000);
    					
    					seckillBox.countdown(killTime,function(event){
    						//时间格式
    						var format = event.strftime('秒杀倒计时： %D天 %H时 %M分 %S秒');
    						seckillBox.html(format);
    					}).on('finish.countdown',function(){
    						//时间完成之后回调事件
    						//获取秒杀地址，控制实现逻辑，执行秒杀
    						seckill.handelseckill(seckillId,seckillBox);
    					});
    				}else{
    					//秒杀开始
    					seckill.handelseckill(seckillId,seckillBox);
    				}
    			},
    			//详情秒杀逻辑
    			detail:{
    				//详情页初始化
    				init : function(params){
    					//用户手机验证和登录，计时交互
    					//交互流程：验证-》
    					//在cookie当中查找手机号码
    					 var killPhone = $.cookie('killPhone');
    					 
    					 if(!seckill.validatePhone(killPhone)){
    						 //绑定手机号
    						 //控制输出
    						 var killPhoneModal = $('#killPhoneModal');
    						 //显示弹出层
    						 killPhoneModal.modal({
    							 show:true,//显示弹出层
    							 backdrop:'static', //禁止位置关闭
    							 keyboard:false 
    						 });
    						 $('#killPhoneBtn').click(function(){
    							 //
    							 var inputPhone = $('#killPhoneKey').val();
    							 if(seckill.validatePhone(inputPhone)){
    								 //电话号码写入cookie
    								 $.cookie('killPhone',inputPhone,{expires:7,path:'/seckill'});
    								 //刷新页面
    								 window.location.reload();
    							 }else{
    								 $('#killPhoneMessage').hide().html('<label class="label label-danger">手机号错误</label>').show(300)
    							 }
    						 });
    					 }
    					 
    					 //用户已经登录
    					 //计时交互
    					 var startTime = params['startTime'];
    					 var endTime = params['endTime'];
    					 var seckillId = params['seckillId'];
    					 $.get(seckill.URL.now(),{},function(result){
    						 if(result && result['success']){
    							 var nowTime = result['data'];
    							 //时间判断  计时交互
    							 seckill.countdown(seckillId,nowTime,startTime,endTime);
    							 
    						 }else{
    							 console.log('result:'+result);
    						 }
    					 })
    				}
    			}
    	}
      
      </script>
   </head>
   <body>
   
	<div class=container>
		<div class="panel panel-default text-center">
			<div class="panel-heading">
				<h1>${seckill.name}</h1>
			</div>
			<div class="panel-body">
				<h2 class="text-danger">
					<span class="glyphicon glyphicon-time"></span>
					<span class="glyphicon" id="seckill-box"></span>
				</h2>
			</div>
		</div>
	</div> 
 	
 	<!-- 登录弹出框 输入电话 -->
 	<div id="killPhoneModal" class="modal fade">
 		<div class="modal-dialog">
 			<div class="modal-content">
 				<div class="modal-header">
 					<h3 class="modal-title text-center">
 						<span class="glyphicon glyphicon-phone"></span>秒杀电话：
 					</h3>
 				</div>
 				<div class="modal-body">
 					<div class="row">
 						<div class="col-xs-8 col-xs-offset-2">
 							<input type="text" name="killPhone" id="killPhoneKey"
		 						placeholder="请填写手机号码" class="form-control"	/>
 						</div>
 					</div>
 				</div>
 				<div class="modal-footer">
 					<span id="killPhoneMessage" class="glyphicon"></span>
 					<button type="button" id="killPhoneBtn" class="btn btn-success">
 						<span class="glyphicon glyphicon-phone"></span>
 						Submit
 					</button>
 					
 				</div>
 				
 			</div>
 		</div>
 	
 	</div>
 
    
 
	
   </body>
   <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.js"></script>
	
	<script src="https://cdn.bootcss.com/jquery.countdown/2.2.0/jquery.countdown.js"></script>
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	
	<!-- 编写交互逻辑 -->
	<!--<script type="text/javascript" src="/resource/script/seckill.js"></script>  -->
	
	<script type="text/javascript">
		$(function(){
			//使用EL传入参数
			seckill.detail.init({
				seckillId: ${seckill.seckillId},
				startTime: ${seckill.startTime.time},		//毫秒时间
				endTime: ${seckill.endTime.time}
			});
		});
	</script>
	
</html>