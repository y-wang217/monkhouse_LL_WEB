<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">

$(document).ready(function() {
	alert("works");
	var y_o_s_mult_var = 1;
	var occupation_multiplier = 1;
	var y_o_s_var = 0;
	$("input[name='seniority_in_years']").keyup(function() {
		var a = $(this).val();
		y_o_s_mult_var = y_o_s_mult(a);
		y_o_s_var = a;

		$('#round').text(normalize(a));
		//$('#raw').text("(" + months(a) + ")");
	});
	$("select[name='occupation_classification']").change(function() {
		var a = this.value;
		occupation_multiplier = a;

		$('#round').text(normalize(a));
		//$('#raw').text("(" + months(a) + ")");
	});

	var normalize = function(a){
		a = even(Math.round(months(a)));
		if(a<12){
			return 12;
		}
		if(a>36){
			return 36;
		}
		return a;
	}
	
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
</script>

<style>
#c_v_emp, #c_dis, #f_cause, #f_t_clause, #a_n_period, #hment, #h_r_dis, #p_dmgs, #ot{
	padding-left:5em
}

div.overseeing_lawyer{
	position: absolute;
	left: 600px;
	top: 0px;
}

p.spaced{
    line-height: 140%;
}
p{
	FONT-FAMILY:Arial,Helvetica,sans-serif;
}
</style>

</head>
<body>
<p>Letter Generation Page</p>
<form action="gen_lawyers_letter">
	<!-- start with filling in the case information -->
	<p style="font-size:20px"> Client info </p>
	<p>	Client first name: <input type="text" name="client_first_name"> Client last name: <input type="text" name="client_last_name">
		Client gender: <select name="client_gender">
    	<option selected="selected"></option>
		<option value="male">male</option>
		<option value="female">female</option>
    	<option value="unspecific">unspecific</option>
	</select>
	
	<div class="overseeing_lawyer">
		<p>Monkhouse Lawyer: <select name="monkhouse_lawyer">
    	<option selected="selected"></option>
		<option value="ahm">Andrew Monkhouse</option>
		<option value="baf">Samantha Lucifora</option>
    	<option value="sjl">Busayo Ayodele</option>
    	<option value="mdm">Stephen LeMesurier</option>
    	</select>
	</div>
	
	<p style="font-size:20px">Client's relevant work factors: </p>
	<p class="spaced">Seniority: <input type="text" maxlength="3" size="3"name="seniority_in_years"> years, <input type="text" maxlength="2" size="2" name="seniority_in_months"> months <br>
		Wage in dollars: $<input type="text" name="wage_in_dollars">.00 per year <br>
		Age: <input type="text" maxlength="3" size="3" name="age"> <br>
		Position: <input type="text" name="position"> <br>
		Client Occupation Classification: <select name="occupation_classification">
    	<option selected="selected" value="1">[Select the category for the position]</option>
		<option value="2">Upper Management (>150k)</option>
		<option value="1.5">Middle Management (b/w 75k and 150k)</option>
    	<option value="1.3">Lower Management (<75k)</option>
    	<option value="1.3">Salesperson</option>
    	<option value="1.3">Professional</option>
    	<option value="0.8">Labourer</option>
    	<option value="0.8">Clerical</option>
    	<option value="1.2">Technical</option>
    	<option value="1.2">Supervisor</option>
    	<option value="1">Social Services</option>
	</select><br>
		Settlement:<div id="round"></div> months
		
		
	<p style="font-size:20px"> Addressing the recipient, OC/HR department: </p>
	<p class="spaced"> Recipient's first name: <input type="text" name="OC_HR_first_name"> Recipient's last name: <input type="text" name="OC_HR_last_name"> <br>
		Recipient's job title: <input type="text" name="OC_HR_job_title"> <br>
		Company's Legal Name: <input type="text" name="OC_HR_company_name">
		Employer Short Form Name: <input type="text" name="employer_first_name"> <br>
		Recipient's company address: <input type="text"  size="35" name="OC_HR_company_address"> <br>
		Recipient's company postal code: <input type="text" maxlength="6" size="6" name="OC_HR_company_postcode"> </p>
		
	
	<p style="font-size:20px"> Other information: </p>
	<p> Termination Date: <input type="text" name="termination_date"> </p>
	<!-- all of the above should be in a header before the document creation -->
	
	<p style="font-size:20px"> Document Sections:</p>
	<!-- choices for different sections to add to the doc -->
	<!-- <p>	Employment Description: <input type="checkbox" name="emp_desc"> -->
	<!-- <p>	Description of Termination: <input type="checkbox" name="termination"> -->
	Contractor vs Employee: <input type="checkbox" name="contractor_vs_emp" id="isContractor_vs_emp">
		<div style="display:none">
			<p id="c_v_emp">Independent Contractor vs Employee: 	<input type="checkbox" name="isUseIndependentContractorVsEmployee"></p>
			<p id="c_v_emp">Dependent Contractor: 					<input type="checkbox" name="isUseDependentContractor"></p>
		</div><br>
		
	Constructive Dismissal: <input type="checkbox" name="constructive_dismissal" id="isConstructive_dismissal">
		<div id="c_dis_div" style="display:none">
			<p id="c_dis">Wage Deductions 						<input type="checkbox" name="isUseWageDeduction"></p>
			<p id="c_dis">Location 								<input type="checkbox" name="isUseLocation"></p>
			<p id="c_dis">Breach of Fundamental Implied Terms 	<input type="checkbox" name="isUseBreachOfFundamentalImpliedTerm"></p>
			<p id="c_dis">Intolerable 							<input type="checkbox" name="isUseIntolerable"></p>
			<p id="c_dis">Workplace Harassment/Poisoned Work Environment	<input type="checkbox" name="isUseWorkplaceHarassmentPoisonedWorkEnvironment"></p>
			<p id="c_dis">Removal from Management Position 		<input type="checkbox" name="isUseRemovalFromManagementPosition"></p>
		</div><br>
		
	Fighting Cause: <input type="checkbox" name="fighting_cause" id="isFighting_cause">
		<div id="f_cause_div" style="display:none">
			<!-- <p id="f_cause">High Standard: 						<input type="checkbox" name="isUseHighStandard"></p> -->
			<p id="f_cause">Gross Incompetence: 						<input type="checkbox" name="isUseGrossIncompetence"></p>
			<p id="f_cause">Standard for Job Abandonment Not Met: 		<input type="checkbox" name="isUseJobAbandonmentDamageAwarded"></p>
			<!-- <p id="f_cause">Damage Awarded: 						<input type="checkbox" name="isUseDamageAward"></p> -->
		</div><br>
	
	Fighting Termination Clause: <input type="checkbox" name="fight_termination_clause" id="isFight_termination_clause">
		<div id="f_t_clause_div" style="display:none">
			<p id="f_t_clause">Basic Start: 						<input type="checkbox" name="isUseBasicStart"></p>
			<p id="f_t_clause">No contracting out of ESA: 			<input type="checkbox" name="isUseNoContractingOutOfESA"></p>
			<p id="f_t_clause">Opting Out of Common Law Notice: 	<input type="checkbox" name="isUseOptingOutOfCommonLawNotice"></p>
			<p id="f_t_clause">Non-Inclusion of Benefits: 			<input type="checkbox" name="isUseNonInclusionOfBenefits"></p>
			<p id="f_t_clause">Potential Violations: 				<input type="checkbox" name="isUsePotentialViolations"></p>
		</div><br>
		
	Bonuses: <input type="checkbox" name="bonus"> <br>
	Pension: <input type="checkbox" name="pension"> <br>
	Appropriate Notice Period: <input type="checkbox" name="appropriate_notice_period" id="isAppropriate_notice_period">
		<div id="a_n_period_div" style="display:none">
			<!--  <p id="a_n_period">Age 									<input type="checkbox" name="isUseAge"></p> -->
			<p id="a_n_period">'Non-Skilled Positions' 				<input type="checkbox" name="isUseNonSkilledPositions"></p>
			<p id="a_n_period">Economic Downturn 					<input type="checkbox" name="isUseEconomicDownturn"></p>
			<!--  <p id="a_n_period">Allegations of Cause 				<input type="checkbox" name="isUseAllegationsOfCause"></p> -->
			<p id="a_n_period">Short term Employees 				<input type="checkbox" name="isUseShortTermEmployees"></p>
			<p id="a_n_period">Short term Employees - Executives 	<input type="checkbox" name="isUseShortTermExecutives"></p>
			<p id="a_n_period">Appropriate Notice Conclusion: 		<input type="checkbox" name="isUseApporpriateNoticeConclusion"></p>
			<p id="a_n_period">Appropriate Notice Alternative: 		<input type="checkbox" name="isUseAppropriateNoticeAlternative"></p>
		</div><br>
		
	Inducement: <input type="checkbox" name="inducement"> <br>
	Harassment: <input type="checkbox" name="harassment" id="isHarassment">
		<div id="hment_div" style="display:none">
			<p id="hment">Harassment - OHSA/Bill 168: 		<input type="checkbox" name="isUseOhsaBill168"></p>
			<p id="hment">Punitive Damages - harassment: 	<input type="checkbox" name="isUsePunitiveDamagesHarassmsnt"></p>
		</div><br>
		
	Human Rights Discrimination: <input type="checkbox" name="human_rights_dis" id="isHuman_rights_dis" checked>
		<div id="h_r_dis_div">
			<p id="h_r_dis">Termination: 		<input type="checkbox" name="isUseTerminationOnProtectedGround"></p>
			<p id="h_r_dis">Age Damages: 		<input type="checkbox" name="isUseAgeDamages"></p>
			<p id="h_r_dis">Damages Chart: 		<input type="checkbox" name="isUseHumanRightsDamagesChart"></p>
		</div><br>
		
	Punitive Damages: <input type="checkbox" name="punitive_dmgs" id="isPunitive_dmgs" checked>
		<div id="p_dmgs_div">
			<p id="p_dmgs">Bad Faith: 									<input type="checkbox" name="isUseBadFaith"></p>
			<p id="p_dmgs">Open and Honest Manner: 						<input type="checkbox" name="isUseOpenAndHonestManner"></p>
			<p id="p_dmgs">Unfavorable Reference: 						<input type="checkbox" name="isUseUnfavourableReference"></p>
			<p id="p_dmgs">Reprisal Harassment: 						<input type="checkbox" name="isUseReprisalHarassmentReport"></p>
			<p id="p_dmgs">Failure to Provide Statutory Requirement: 	<input type="checkbox" name="isUseFailureToProvideStatutoryRequirement"></p>
			<p id="p_dmgs">Reprisal OHSA: 								<input type="checkbox" name="isUseReprisalOhsa"></p>
			<p id="p_dmgs">Allegations of Cause: 						<input type="checkbox" name="isUseAllegationsOfCause"></p>
		</div><br>
		
	Overtime: <input type="checkbox" name="overtime" id="isOvertime">
		<div id="ot_div" style="display:none">
			<p id="ot">CLC: 					<input type="checkbox" name="isUseClc"></p>
			<p id="ot">Performance Ontario: 	<input type="checkbox" name="isUsePerformanceOntario"></p>
		</div><br>
	
	<input type="submit">
</form>
</body>
</html>