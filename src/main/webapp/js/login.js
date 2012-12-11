
$(function($) {
	var this_input;
  	var this_s;
	var this_text;
	var subimt = false;
	if($("#msg_error").html() != "" && $("#msg_error").html() != null){
		$("#main #login_window .msg_input:eq(0)").html($("#msg_error div").html());
		$("#main #login_window .msg_input:eq(0)").addClass("block");
	}
	
	$("input[type='text']").val("");
	
	
	$("#login_window .text .s").bind("click",function(){
		this_s = $(this);
		this_text = this_s.parent();
		this_s.hide();
		this_text.children("input").select();
		this_text.children("input").bind("blur",function(){
			if($.trim($(this).val()) == ""){
				this_s.show();
			}else{
				this_text.next().removeClass("block");
			}
		})
	});
	
	$("#login_window .text input[type='text'],#login_window .text input[type='password']").bind("focus",function(){
		this_input = $(this);
		this_s = this_input.next();
		this_text = this_input.parent();
		this_s.hide();
		this_text.children("input").bind("blur",function(){
			if($.trim($(this).val()) == ""){
				this_s.show();
			}else{
				this_text.next().removeClass("block");
			}
		})
	});
	
	
});

















