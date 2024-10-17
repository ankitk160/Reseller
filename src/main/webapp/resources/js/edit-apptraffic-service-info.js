/* Function to get operators using territoryid */
function getOperators(territoryid) {
	$.ajax({
		type: "POST",
		url: "getOperatorByTerritoryId",
		data: territoryid,
		dataType: "html",
		contentType: "application/text",
		success: function(result) {
			var jsonResult = JSON.parse(result);
			var operatorid = $("#operatorid");
			var oprId = appTSInfoData;
			operatorid.empty();
			$.each(jsonResult, function(index, item) {
				var option = $("<option>").val(item.id).text(
					item.id + " - " + item.name);
				if (item.id == oprId) {
					option.attr("selected", "selected")
				}
				operatorid.append(option);
			});
		}
	});
};

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

/* Function to get appcampaigns using operatorid */
function getAppCampaigns(operatorid) {
	var url = "getAppCampaignByOperatorId?operatorid=" + operatorid;
	$.ajax({
		type: "POST",
		url: url,
		dataType: "html",
		contentType: "application/text",
		success: function(result) {
			var jsonResult = JSON.parse(result);
			var appcampaign = $("#appcampaign");
			appcampaign.empty();
			$.each(jsonResult, function(index, item) {
				var option = $("<option>").val(item.partnerid)
					.text(
						item.id + " - "
						+ item.campaign_name);
				appcampaign.append(option);
			});
		}
	});
};

/* Appending appcampaigndetails using above function when page loads and change event occurs */
$('#operatorid').on(
	'change',
	function() {
		var selectedOperatorId = this.value;
		getAppCampaigns(selectedOperatorId);
	});

$(document).ready(function() {
	var selectedOperatorId = appTSInfoData;
	getAppCampaigns(selectedOperatorId);
});