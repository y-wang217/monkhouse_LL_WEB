
$(document).ready(function() {
	alert("works");
	var y_o_s_mult_var = 1;
	var occupation_multiplier = 1;
	var y_o_s_var = 0;
	$("input[name='seniority_in_years']").keyup(function() {
		var a = $(this).val();
		y_o_s_mult_var = y_o_s_mult(a);
		y_o_s_var = a;

		$('#round').text(even(Math.round(months(a))));
		$('#raw').text("(" + months(a) + ")");
	});
	$("select[name='occupation_classification']").change(function() {
		var a = this.value;
		occupation_multiplier = a;
		
		$('#round').text(even(Math.round(months(a))));
		$('#raw').text("(" + months(a) + ")");
	});

	var even = function(a){
		if(a%2==1){
			return a+1;
		}else{
			return a;
		}
	}
	
	var months = function(a) {
		return y_o_s_var * y_o_s_mult_var * occupation_multiplier * 1.5;
	}
	var y_o_s_mult = function(a) {
		if (a > 0 && a <= 2.5) {
			return 2.6;
		}
		if (a >= 2.6 && a <= 5) {
			return 1.4;
		}
		if (a >= 5.1 && a <= 10) {
			return 1.1;
		}
		if (a >= 10.1 && a <= 15.5) {
			return 0.9;
		}
		if (a >= 15.6 && a <= 20.5) {
			return 0.8;
		}
		if (a >= 20.6 && a <= 25) {
			return 0.7;
		}
		if (a >= 25.1) {
			return 0.6;
		} else
			return 1;
	}

    $("#isConstructive_dismissal").click(function(){
    	$("#c_v_emp_div").toggle(this.checked);
    });
    $("#isConstructive_dismissal").click(function(){
    	$("#c_dis_div").toggle(this.checked);
    });
    $("#isFighting_cause").click(function(){
    	$("#f_cause_div").toggle(this.checked);
    	$('input[name=isUseAllegationsOfCause]').toggle(this.checked);
    });
    $("#isFight_termination_clause").click(function(){
    	$("#f_t_clause_div").toggle(this.checked);
    });
    $("#isAppropriate_notice_period").click(function(){
    	$("#a_n_period_div").toggle(this.checked);
    });
    $("#isHarassment").click(function(){
    	$("#hment_div").toggle(this.checked);
    });
    $("#isHuman_rights_dis").click(function(){
    	$("#h_r_dis_div").toggle(this.checked);
    });
    $("#isPunitive_dmgs").click(function(){
    	$("#p_dmgs_div").toggle(this.checked);
    });
    $("#isOvertime").click(function(){
    	$("#ot_div").toggle(this.checked);
    });
});