/**
 * 
 */

$(document).ready(function() {
	$("#isConstructive_dismissal").click(function() {
		$("#c_dis_div").toggle(this.checked);
	});
	$("#isFighting_cause").click(function() {
		$("#f_cause_div").toggle(this.checked);
	});
	$("#isFight_termination_clause").click(function() {
		$("#f_t_clause_div").toggle(this.checked);
	});
	$("#isAppropriate_notice_period").click(function() {
		$("#a_n_period_div").toggle(this.checked);
	});
	$("#isHarassment").click(function() {
		$("#hment_div").toggle(this.checked);
	});
	$("#isHuman_rights_dis").click(function() {
		$("#h_r_dis_div").toggle(this.checked);
	});
	$("#isPunitive_dmgs").click(function() {
		$("#p_dmgs_div").toggle(this.checked);
	});
	$("#isOvertime").click(function() {
		$("#ot_div").toggle(this.checked);
	});
});