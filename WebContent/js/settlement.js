/**
 * 
 */
$(document).ready(function() {
	var y_o_s_mult_var = 1;
	var occupation_multiplier = 1;
	var y_o_s_var = 0;
	$("input[name='years_of_service']").keyup(function() {
		var a = $(this).val();
		y_o_s_mult_var = y_o_s_mult(a);
		y_o_s_var = a;

		$('#round').text(Math.round(months(a)));
		$('#raw').text("(" + months(a) + ")");
	});
	$("select[name='client_occupation']").change(function() {
		var a = this.value;
		occupation_multiplier = a;
		
		$('#round').text(Math.round(months(a)));
		$('#raw').text("(" + months(a) + ")");
	});

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
/*
	var x_pos = 500;
	var y_pos = 200;
	var d = document.getElementById('test');
	d.style.position = "absolute";
	d.style.left = x_pos + 'px';
	d.style.top = y_pos + 'px';
*/
});