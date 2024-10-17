/* Function to get appcampaigndetails using operatorid */
$('#operatorid').on(
	'change',
	function() {
		var selectedOperatorId = this.value;
		$.ajax({
			type: "POST",
			url: "getAppCampaignByOperatorId",
			data: selectedOperatorId,
			dataType: "html",
			contentType: "application/text",
			success: function(result) {
				var jsonResult = JSON.parse(result);
				var appcampaign = $("#appcampaign");
				appcampaign.empty();
				$.each(jsonResult, function(index, item) {
					var option = $("<option>").val(item.id).text(
						item.id + " - " + item.campaign_name);
					appcampaign.append(option);
				});
			}
		});
	});

/* Function to get operators using territoryid */
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