<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Editor</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(
			function() {
				var docSelected;
				var secSelected;
				$("#document_select").change(function() {
					var selected_doc = $(this).val();
					if (selected_doc == "ll") {
						$('#section_select_soc').hide();
						$('#section_select_soc').value = "";
						$('#section_select_ll').show();
					}
					if (selected_doc == "soc") {
						$('#section_select_ll').hide();
						$('#section_select_ll').value = "";
						$('#section_select_soc').show();
					}
					docSelected = $(this).val();
				})

				$(".section_sel").change(function() {
					$('#submit_edit_button').show();
					secSelected = $(this).val();
				})

				$('#submit_edit_button').on(
						'click',
						function() {
							$("textarea").remove();
							var Status = $(".section_sel").val();
							if (Status == "") {
								alert("Please select a valid section");
								return false;
							}
							$.ajax({
								url : 'section_editor',
								type : 'GET',
								data : {
									doc : docSelected,
									section : secSelected
								},
								dataType : 'json',

								success : function(data) {
									processSectionContent(data);
								},

								error : function(data, status, er) {
									alert("error: " + data + " status: "
											+ status + " er:" + er);
								}
							});
						});
			});
			var processSectionContent = function(contentArray){
				contentArray.forEach( function (arrayItem)
						{
						    //alert(arrayItem);
							editArea = document.createElement("textarea");
							editArea.value = arrayItem;
							$("#edit_area").append('<br><br>');
							$("#edit_area").append(editArea);
						});
			}
			$('#submit_edit_button').on(
					'click',
					function() {
						$.ajax({
							url : 'section_confirm',
							type : 'GET',
							data : {
								prev : docSelected,
								section : secSelected
							},
							dataType : 'json',

							success : function(data) {
								processSectionContent(data);
							},

							error : function(data, status, er) {
								alert("error: " + data + " status: "
										+ status + " er:" + er);
							}
						});
						
					});
</script>
</head>
<body>

	Select a Document:
	<select id="document_select" name="selected_doc">
		<option value="" selected="selected"></option>
		<option value="ll">Lawyer's Letter</option>
		<option value="soc">Statement of Claim</option>
	</select>
	<br> Select a section:
	<select class="section_sel" id="section_select_ll"
		style="display: none;" name="selected_section">
		<option value="" selected="selected"></option>
		<option value="APPROPRIATE_NOTICE_PERIOD">Appropriate Notice</option>
		<option value="BONUS">Bonuses</option>
		<option value="CONSTRUCTIVE_DISMISSAL">Constructive Dismissal</option>
		<option value="CONTRACTOR_VS_EMP">Contractor VS Employee</option>
		<option value="FIGHTING_CAUSE">Fighting Cause</option>
		<option value="FIGHT_TERMINATION_CLAUSE">Fight Termination
			Clause</option>
		<option value="HARASSMENT">Harassment</option>
		<option value="HUMAN_RIGHTS_DIS">Human Rights Discrimination</option>
		<option value="INDUCEMENT">Inducement</option>
		<option value="MOVING_FWD">Moving Forward</option>
		<option value="OPENING">Opening</option>
		<option value="OVERTIME">Overtime</option>
		<option value="PENSION">Pensions</option>
		<option value="PUNITIVE_DMGS">Punitive Damages</option>
	</select>
	<select class="section_sel" id="section_select_soc"
		style="display: none;" name="selected_section">
		<option value="" selected="selected"></option>
		<option value="ALLEGATIONS">Allegations of Cause</option>
		<option value="BACKGROUND">Background</option>
		<option value="BAD_FAITH">Bad Faith and Duty of Honesty</option>
		<option value="BONUSES_OTHERS">Bonuses and Other Benefits</option>
		<option value="ABoCDSR">Breah of Clause</option>
		<option value="LOCATION">Changed Location</option>
		<option value="CLC">CLC Overtime</option>
		<option value="CONSTRUCTIVE">Constructive Dismissal</option>
		<option value="DAMAGE_AWARD">Damage Award</option>
		<option value="NOT_EXCLUDE">Does Not Exclude Common Law</option>
		<option value="END">End (final section at the end)</option>
		<option value="FAIL_MINIMUMS">Failure to Provide Minimums</option>
		<option value="FIGHTING_CAUSE">Fighting Cause</option>
		<option value="FIGHTING_TERM">Fighting Termination</option>
		<option value="GROSS">Gross Incompetence</option>
		<option value="HARASSMENT">Harassment</option>
		<option value="HIGH_STANDARD">Hight Standard for Cause</option>
		<option value="HUMAN_RIGHTS">Human Rights</option>
		<option value="INDEPENDENT">Independent Contractor vs
			Employee</option>
		<option value="INDUCEMENT">Inducement</option>
		<option value="INTOLERABLE">Intolerable Work Environment</option>
		<option value="ABANDONMENT">Job Abandonment</option>
		<option value="NO_CONTRACTING">No Contract ESA</option>
		<option value="NON_BENEFITS">Non-Continuation of Benefits</option>
		<option value="OHSA">OHSA 168</option>
		<option value="ONT_OVERTIME">Ontario Overtime</option>
		<option value="OPEN_HONEST">Open and Honest Manner</option>
		<option value="POISONED">Poisoned Work Environment</option>
		<option value="POT_VIOLATIONS">Potential Future Violations</option>
		<option value="PUN_AGG_MOR_DMGS">Punitive Aggravate Moral
			Damages</option>
		<option value="PUNITIVE_HARASSMENT">Punitive Damages -
			Harassment</option>
		<option value="REMOVAL_MANAGEMENT">Removal from Management</option>
		<option value="TERMINATION">Termination</option>
		<option value="PARTIES">The Parties (statement)</option>
		<option value="WAGE">Wage Deduction</option>
		<option value="WORKPLACE_HARASSMENT">Workplace Harassment</option>
		<option value="WRONGFUL">Wrongful Dismissal</option>
	</select>
	<br>


	<input type='button' value='EDIT SECTION' id="submit_edit_button">
	
	<div id="edit_area">
	
	<input type='button' value='CONFIRM EDIT' id="confirm_submit_button">
	</div>
</body>
</html>