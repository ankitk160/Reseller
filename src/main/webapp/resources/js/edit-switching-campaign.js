/* To show collapse when page load */
$(document).ready(function() {
	if ($('#switchBaseCampaignFlag').is(':checked')) {
		$('#collapseExample1').collapse('show');
	} else {
		$('#collapseExample1').collapse('hide');
	}

	if ($('#switchCampaignFlag_1').is(':checked')) {
		$('#collapseExample2').collapse('show');
	} else {
		$('#collapseExample2').collapse('hide');
	}
});

/* Function to get operators using territoryid */
function getOperators(territoryId) {
	$.ajax({
		type: "POST",
		url: "getOperatorByTerritoryId",
		data: territoryId,
		dataType: "html",
		contentType: "application/text",
		success: function(result) {
			var jsonResult = JSON.parse(result);
			var operator = $("#operatorid");
			var oprId = operatorData;
			operator.empty();
			$.each(jsonResult, function(index, item) {
				var option = $("<option>").val(item.id).text(
					item.id + " - " + item.name);
				if (item.id == oprId) {
					option.attr("selected", "selected");
				}
				operator.append(option);
			});
		}
	});
}

/* Appending operators using above function when page loads and change event occurs  */
$('#territoryid').on(
	'change',
	function() {
		var selectedTerritoryId = this.value;
		getOperators(selectedTerritoryId);
	});

$(document).ready(function() {
	var selectedTerritoryId = $('#territoryid').val();
	getOperators(selectedTerritoryId);
});

/* Function to get appTSInfos using promoterName and operatorid */
function getAppTSInfo(operatorId, promoterName) {
	var url = "getATSInfoByIds?operatorid=" + operatorId
		+ "&PromoterName=" + promoterName;
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
			var campId = switchingData.switchingCampId;
			var campId_1 = switchingData.switchingCampId_1;
			var campId_2 = switchingData.switchingCampId_2;
			appTSInfo1.empty();
			appTSInfo2.empty();
			appTSInfo3.empty();
			$.each(jsonResult, function(index, item) {
				var option1 = $("<option>").val(item.id).text(
					item.id + " - " + item.servicename);
				if (item.id == campId) {
					option1.attr("selected", "selected");
				}
				var option2 = $("<option>").val(item.id).text(
					item.id + " - " + item.servicename);
				if (item.id == campId_1) {
					option2.attr("selected", "selected");
				}
				var option3 = $("<option>").val(item.id).text(
					item.id + " - " + item.servicename);
				if (item.id == campId_2) {
					option3.attr("selected", "selected");
				}
				appTSInfo1.append(option1);
				appTSInfo2.append(option2);
				appTSInfo3.append(option3);
			});
		}
	});
}

/* Appending appTSInfos using above function when page loads and change event occurs */
$('#promoterName').change(
	function() {
		var selectedPromoter = this.value;
		var selectedOperator = $('#operatorid').val();
		getAppTSInfo(selectedOperator, selectedPromoter);
	});

$(document).ready(function() {
	var selectedPromoter = $('#promoterName').val();
	var oprId = operatorData;
	getAppTSInfo(oprId, selectedPromoter);
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
};