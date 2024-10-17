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
			var oprId = campaignData;
			operatorid.empty();
			$.each(jsonResult, function(index, item) {
				var option = $("<option>").val(item.id).text(
					item.id + " - " + item.name);
				if (item.id == oprId) {
					option.attr("selected", "selected");
				}
				operatorid.append(option);
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