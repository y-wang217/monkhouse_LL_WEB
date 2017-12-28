<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
function sendDivInfo(){
	document.getElementById("settlement_input").value = document.getElementById("round").innerHTML;
}
$(document).ready(function() {
	$("select[name='OCvsHR']").on({ 
		"change": function() {
	    	choice = $(this).val();
	    	//console.log('changed!', this, choice);
	    	this.blur();
	    	setTimeout(function() { alert('Chose '+ choice); }, 0);
	    }
	});
	//alert("works");
	var y_o_s_var = (typeof y_o_s_var === 'undefined')?0:$("input[name='seniority_in_years']").val;
	var y_o_s_mult_var = (y_o_s_var == 0)?1:y_o_s_mult(y_o_s_var);
	var occupation_multiplier = (typeof occupation_multiplier === 'undefined')?1:$("input[name='occupation_multiplier']").val;
	$("input[name='seniority_in_years']").keyup(function() {
		var a = $(this).val();
		if(!a){a=0;}
		y_o_s_mult_var = y_o_s_mult(a);
		y_o_s_var = a;

		$('#round').text(normalize(a));
		//$('#raw').text("(" + months(a) + ")");
		$("#settlement_input").val($('#round').text());
	});
	$("select[name='occupation_classification']").change(function() {
		var a = this.value;
		occupation_multiplier = a;

		$('#round').text(normalize(a));
		//$('#raw').text("(" + months(a) + ")");
		$("#settlement_input").val($('#round').text());
	});
	$("#select_all_button").click(function(){
		$(':checkbox').each(function() {
            this.checked = true;                        
        });
	});

	var normalize = function(a){
		a = even(Math.round(months(a)));
		if(a==0){
			return 0;
		}
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
	
	//auto generate age based on given birthdate
	$("#birthdate").change(function(){
		var d = new Date();
		var yearToday = d.getFullYear();
		var age = parseInt(yearToday) - parseInt($("#birthdate").val().substring(6, 10));
    	$("#age").val(age);
	});
	//auto generate seniority based on given start date and end date
	$("#termination_date").change(function(){
	    if(!$("#start_date").val()){
	    	alert("insert start date.")
	    	return;
	    }
		var yearStart = $("#start_date").val().substring(6, 10);
	    var seniority = parseInt($("#termination_date").val().substring(6, 10)) - yearStart;
	    //alert(seniority);
    	$("#seniority_in_years").val(seniority);
	});
	
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
    $("#isBonus").click(function(){
    	$("#bonus_div").toggle(this.checked);
    });
    $("#isInducement").click(function(){
    	$("#inducement_div").toggle(this.checked);
    });
    
    //change value: on click, text dissappears
    $("#employment_clause")
    .focus(function() {
          if (this.value === this.defaultValue) {
              this.value = '';
          }
    })
    .blur(function() {
          if (this.value === '') {
              this.value = this.defaultValue;
          }
  	});
});
</script>

<style>
#c_v_emp, #c_dis, #f_cause, #f_t_clause, #a_n_period, #hment, #h_r_dis, #p_dmgs, #ot, #bonus_clause{
	padding-left:5em
}

div.overseeing_lawyer{
	position: absolute;
	left: 800px;
	top: 0px;
}

p.spaced{
    line-height: 140%;
}
p{
	FONT-FAMILY:Arial,Helvetica,sans-serif;
}

.settlement{
	display:inline-block;
}

</style>

</head>
<body>
<p>Letter Generation Page</p>
<form action="gen_lawyers_letter" onsubmit="sendDivInfo()">
	<!-- start with filling in the case information -->
	<p style="font-size:20px"> Client info: </p>
	<p>	Client first name: <input type="text" name="client_first_name"> Client last name: <input type="text" name="client_last_name">
	<br>Client residing city/town: <input type="text" name="client_city">
		Client gender: <select name="client_gender">
    	<option selected="selected"></option>
		<option value="male">male</option>
		<option value="female">female</option>
    	<option value="unspecific">unspecific</option>
	</select>
	
	<div class="overseeing_lawyer">
		<p>Monkhouse Lawyer: <select name="monkhouse_lawyer">
		<option value="AHM" selected="selected">Andrew Monkhouse</option>
		<option value="SDL">Samantha Lucifora</option>
    	<option value="BAF">Busayo Ayodele</option>
    	<option value="SJL">Stephen LeMesurier</option>
    	<option value="MDM">Miguel Mangalindan</option>
    	
    	</select>
    	
    	<p>Drafted by: <select name="monkhouse_paralegal">
    	<option selected="selected"></option>
		<option value="msb">Miyoshi Bonyun</option>
		<option value="alh">Andrea Hossack</option>
    	<option value="cal">Cassandra Liu</option>
    	<option value="rsf">Rachel Flommerfelt</option>
    	<option value="amg">Anessa Garcia</option>
    	<option value="mmr">Milcah Rodriguez</option>
    	<option value="ckk">Catherine Kim</option>
    	</select>
    	
    	<p>This letter is a: <select name="isDraft">
		<option value="true" >Draft LP</option>
		<option value="false" selected="selected">Final LP</option>
    	</select>
    	
    	<br>
    	<br>
    	<p>Jurisdiction: <select name="jurisdiction">
    	<option value="prov" selected="selected">Provincially regulated</option>
    	<option value="fed">Federally regulated</option>
    	</select>
	</div>
	
	<p style="font-size:20px">Client's relevant work factors: </p>
	<p class="spaced">Start Date: <input type="text" name="start_date" id="start_date" maxlength="10"> (DD/MM/YYYY)<br>
		Termination Date: <input type="text" name="termination_date" id="termination_date" maxlength="10"> (DD/MM/YYYY)<br>
		Seniority*: <input type="text" maxlength="3" size="3" name="seniority_in_years" id="seniority_in_years"> years, <input type="text" maxlength="2" size="2" name="seniority_in_months"> months <br>
		Wage in dollars*: $<input type="text" name="wage_in_dollars">.00 per year  (no commas)<br>
		Birthday (DD/MM/YYYY): <input type="text" maxlength="10" name="birthdate" id="birthdate"> <br>
		Age*: <input type="text" maxlength="3" size="3" name="age" id="age"> <br>
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
	</select><br> (Note: Please reselect the occupation classification if you pressed 'back')
		<input type="hidden" name="settlement" id="settlement_input">
		<div class="settlement">Settlement:</div><div class="settlement" id="round">  </div> <div class="settlement">months</div>
		
		
	<p style="font-size:20px"> Addressing the recipient, OC/HR department: </p>
	<p class="spaced"> OC vs HR: <select name="OCvsHR">
		<option value="hr" selected="selected" onchange="if (this.selectedIndex) doSomething();">HR (employer>)</option>
		<option value="oc">OC (lawyer)</option>
		</select><br>
		<div id="hr_info_div">
		Recipient's first name: <input type="text" name="OC_HR_first_name"> Recipient's last name: <input type="text" name="OC_HR_last_name"> <br>
		Recipient's job title: <input type="text" name="OC_HR_job_title"> <br>
		Company's Legal Name: <input type="text" name="OC_HR_company_name">
		Employer Short Form Name: <input type="text" name="employer_first_name"> <br>
		Company address: <input type="text"  size="35" name="OC_HR_company_address"> <br>
		City: <input type="text"  size="20" name="OC_HR_company_city"> Province: <input type="text"  size="2" name="OC_HR_company_province">
		Company postal code: <input type="text" maxlength="6" size="6" name="OC_HR_company_postcode"> </p>
		</div>
		<div id="oc_info_div" style="display:none">
		Recipient's first name: <input type="text" name="OC_HR_first_name"> Recipient's last name: <input type="text" name="OC_HR_last_name"> <br>
		Recipient's job title: <input type="text" name="OC_HR_job_title"> <br>
		Company's Legal Name: <input type="text" name="OC_HR_company_name">
		Employer Short Form Name: <input type="text" name="employer_first_name"> <br>
		Recipient's company address: <input type="text"  size="35" name="OC_HR_company_address"> <br>
		Recipient's company postal code: <input type="text" maxlength="6" size="6" name="OC_HR_company_postcode"> </p>
		<br>
		"Employment was pursuant to a <select name="verbal_or_written"> 
		<option value="verbal" selected="selected">verbal</option>
		<option value="written" selected="selected">written</option>
		</select> agreement"
		<!--  Additional background information? <input type="checkbox" id="is_additional_background_info">
			<div id="additional_background_info_div">Insert additional background info: <br>
			<textarea rows="4" cols="50" id="additional_background_info_box" name="additional_background_info"></textarea>
			</div> -->
		</div>
	

	
	<p style="font-size:20px"> Document Sections:</p>
	<input type="button" value="Select all" id="select_all_button">
	<!-- choices for different sections to add to the doc -->
	<!-- <p>	Employment Description: <input type="checkbox" name="emp_desc"> -->
	<!-- <p>	Description of Termination: <input type="checkbox" name="termination"> -->
	
	Appropriate Notice Period: <input type="checkbox" name="appropriate_notice_period" id="isAppropriate_notice_period" checked>
		<div id="a_n_period_div">
			<!--  <p id="a_n_period">Age 									<input type="checkbox" name="isUseAge"></p> -->
			<p id="a_n_period">'Non-Skilled Positions' 				<input type="checkbox" name="isUseNonSkilledPositions"></p>
			<p id="a_n_period">Economic Downturn 					<input type="checkbox" name="isUseEconomicDownturn" checked></p>
			<!--  <p id="a_n_period">Allegations of Cause 				<input type="checkbox" name="isUseAllegationsOfCause"></p> -->
			<p id="a_n_period">Short term Employees 				<input type="checkbox" name="isUseShortTermEmployees"></p>
			<p id="a_n_period">Short term Employees - Executives 	<input type="checkbox" name="isUseShortTermExecutives"></p>
			<p id="a_n_period">Appropriate Notice Conclusion: 		<input type="checkbox" name="isUseApporpriateNoticeConclusion"></p>
			<p id="a_n_period">Appropriate Notice Alternative: 		<input type="checkbox" name="isUseAppropriateNoticeAlternative"></p>
		</div><br>
		
	Contractor vs Employee: <input type="checkbox" name="contractor_vs_emp" id="isContractor_vs_emp">
		<div style="display:none">
			<p id="c_v_emp">Independent Contractor vs Employee: 	<input type="checkbox" name="isUseIndependentContractorVsEmployee">
			<!--  Insert factual information in relation to client being an employee: <textarea id="independent_vs_employee" rows="4" cols="50" name="independent_vs_employee"></textarea> -->
			</p>
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
			
			<!-- Include if giving contextual information about allegations of cause -->
			<!-- Contextual information about allegations of cause*: <textarea id="fighting_cause_context" rows="4" cols="50" name="fighting_cause_contextual_info"></textarea> -->
		</div><br>
	
	Fighting Termination Clause: <input type="checkbox" name="fight_termination_clause" id="isFight_termination_clause">
		<div id="f_t_clause_div" style="display:none">
			<p id="f_t_clause">Basic Start: 						<input type="checkbox" name="isUseBasicStart" checked></p>
			<p id="f_t_clause">Employment Clause Insert:			</p>
			<!-- <p id="f_t_clause"><textarea id="employment_clause" rows="4" cols="50" name="contract_termination_clause_insert">
Paste in employment clause here: 
			</textarea></p> -->
			<p id="f_t_clause">No contracting out of ESA: 			<input type="checkbox" name="isUseNoContractingOutOfESA"></p>
			<p id="f_t_clause">Opting Out of Common Law Notice: 	<input type="checkbox" name="isUseOptingOutOfCommonLawNotice"></p>
			<p id="f_t_clause">Non-Inclusion of Benefits: 			<input type="checkbox" name="isUseNonInclusionOfBenefits"></p>
			<p id="f_t_clause">Potential Violations: 				<input type="checkbox" name="isUsePotentialViolations"></p>
			
			<!-- below is only included if using alternative -->
			<p id="f_t_breach_clause">Alterative: Defendent breached clause <input type="checkbox" name="isUseBreachClauseAlternative">
				<textarea id="reason_possible_breach" name="reason_possible_breach" rows="4" cols="50" ></textarea>
			</p>
		</div><br>
		
	Bonuses: <input type="checkbox" name="bonus" id="isBonus"> <br>
		<div id="bonus_div" style="display:none">
			<p id="bonus_clause">Yearly Bonus Amt:							<input type="text" name="yearly_bonus"></p>
			<p id="bonus_clause">No. of months worked without bonus paid:	<input type="text" name="months_bonus_owed"></p>
		</div>
			
	Pension: <input type="checkbox" name="pension"> <br>
		
	Inducement: <input type="checkbox" name="inducement" id="isInducement"> <br>
		<div id="inducement_div" style="display:none">
		<!-- TODO: make this appear and disappear -->
			<p id="inducement_text">Previous employer: <input type="text" name="previous_employer">
			<p id="inducement_text">Previous employment tenure: <input type="text" name="previous_employment_tenure">
			<p id="inducement_text">Insert information on how inducement happened: <textarea rows="4" cols="50" id="inducement_info" name="inducement_info"></textarea>
		</div>
	Harassment: <input type="checkbox" name="harassment" id="isHarassment">
		<div id="hment_div" style="display:none">
			<p id="hment">Harassment - OHSA/Bill 168: 		<input type="checkbox" name="isUseOhsaBill168"></p>
			<p id="hment">Facts about harassment: <textarea rows="4" cols="50" id="harassment_info" name="harassment_info"></textarea>
			<p id="hment">Punitive Damages - harassment: 	<input type="checkbox" name="isUsePunitiveDamagesHarassmsnt"></p>
		</div><br>
		
	Human Rights Discrimination: <input type="checkbox" name="human_rights_dis" id="isHuman_rights_dis" checked>
		<div id="h_r_dis_div">
			<p id="h_r_dis">Termination on Protected Ground: 		<input type="checkbox" name="isUseTerminationOnProtectedGround"></p>
			<p id="h_r_dis">Age Damages: [included if age > 45] 		<!-- <input type="checkbox" name="isUseAgeDamages"></p> -->
			<p id="h_r_dis">Damages Chart: 		<input type="checkbox" name="isUseHumanRightsDamagesChart"></p>
			<!-- SOC additional content -->
			<!-- Our client pleads that their [insert grounds for discrimination] <input type=text name="grounds_for_discrimination"> <br> -->
				<input type="checkbox" name="non-specific">
				<input type="checkbox" name="ancestry/ethnicity">
				<input type="checkbox" name="disability">
				<input type="checkbox" name="family status">
				<input type="checkbox" name="marital status">
				<input type="checkbox" name="sex/sexual orientation">
				<input type="checkbox" name="creed">
			<input type=hidden name="human_rights_legislation" value="yes">
			<div id="human_rights_facts_div">Insert factual circumstances relating to allegations of discrimination: <br>
				<textarea rows="4" cols="50" id="human_rights_facts_box" name="human_rights_facts"></textarea>
			</div>
			<!-- <p id="h_r_dis">Use 30 days affidavit? 		<input type="checkbox" name="isUse30DaysAffitdavit"></p> -->
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
			<p id="ot_calc">Hours worked per week: <input type="text" name="hoursWorkedPerWeek"></p>
			<p id="ot">Performance Ontario: 	<input type="checkbox" name="isUsePerformanceOntario"></p>
		</div><br>
	
	<input type="submit">
</form>
</body>
</html>