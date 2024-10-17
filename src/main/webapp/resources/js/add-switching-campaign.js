/* Appending operators in respective fields  */
$('#territoryid').on(
	'change',
	function() {
		var selectedTerritoryId = this.value;
		$.ajax({
			type: "POST",
			url: "getOperatorByTerritoryId",
			data: selectedTerritoryId,
			dataType: "html",
			contentType: "application/text",
			success: function(result) {
				var jsonResult = JSON.parse(result);
				var operatorid = $("#operatorid");
				operatorid.empty();
				operatorid.append($("<option>").text(
					"-Select Operator-"));
				$.each(jsonResult, function(index, item) {
					var option = $("<option>").val(item.id).text(
						item.id + " - " + item.name);
					operatorid.append(option);
				});
			}
		});
	});

/* Appending AppTSInfo in respective fields */
$('#promoterName').change(
	function() {
		var selectedPromoter = $(this).val();
		var selectedOperator = $('#operatorid').val();
		var url = "getATSInfoByIds?operatorid=" + selectedOperator
			+ "&PromoterName=" + selectedPromoter;
		$.ajax({
			type: "POST",
			url: url,
			dataType: "html",
			contentType: "application/text",
			success: function(result) {
				var jsonResult = JSON.parse(result);
				var appTSInfo1 = $("#appTSInfo1");
				var appTSInfo2 = $("#appTSInfo2");
				var appTSInfo3 = $("#appTSInfo3");
				appTSInfo1.empty();
				appTSInfo2.empty();
				appTSInfo3.empty();
				$.each(jsonResult, function(index, item) {
					var option1 = $("<option>").val(item.id).text(
						item.id + " - " + item.servicename);
					var option2 = $("<option>").val(item.id).text(
						item.id + " - " + item.servicename);
					var option3 = $("<option>").val(item.id).text(
						item.id + " - " + item.servicename);
					appTSInfo1.append(option1);
					appTSInfo2.append(option2);
					appTSInfo3.append(option3);
				});
			}
		});
	});

/* For disable second level switching when first is disabled and setting required fields true for first level switching*/
const switchBaseCampaignFlag = document
	.getElementById("switchBaseCampaignFlag");
const switchCampaignFlag_1 = document
	.getElementById("switchCampaignFlag_1");
const appTSInfo2 = document.getElementById("appTSInfo2");
const switchingCampCap_1 = document
	.getElementById("switchingCampCap_1");
switchBaseCampaignFlag.addEventListener("change", function() {
	if (switchBaseCampaignFlag.checked) {
		appTSInfo2.required = true;
		switchingCampCap_1.required = true;
		switchCampaignFlag_1.disabled = !switchCampaignFlag_1.disabled;
	} else {
		switchingCampCap_1.required = false;
		appTSInfo2.required = false;
	}
});

/* For setting required fields true for second level switching*/
const switchSecondLevel = document
	.getElementById("switchCampaignFlag_1");
const appTSInfo3 = document.getElementById("appTSInfo3");
switchSecondLevel.addEventListener("change", function() {
	if (switchSecondLevel.checked) {
		appTSInfo3.required = true;
	} else {
		appTSInfo3.required = false;
	}
});

/* To check selected values of select elements are different */
document.getElementById('myForm').onsubmit = function() {
	var switchingCampId = document.getElementById('appTSInfo1').value;
	var switchingCampId_1 = document.getElementById('appTSInfo2').value;
	var switchingCampId_2 = document.getElementById('appTSInfo3').value;
	var switchCampaignFlag_1 = document.getElementById('switchCampaignFlag_1');
	var switchBaseCampaignFlag = document.getElementById('switchBaseCampaignFlag');
	if (switchBaseCampaignFlag.checked) {
		if (switchCampaignFlag_1.checked) {
			if (switchingCampId == switchingCampId_1 || switchingCampId_1 == switchingCampId_2 || switchingCampId_2 == switchingCampId) {
				alert("All three selected campaigns should be different");
				return false;
			}
		} else {
			if (switchingCampId == switchingCampId_1) {
				alert("Selected campaigns should be different");
				return false;
			}
		}
	} else {
		return true;
	}
};