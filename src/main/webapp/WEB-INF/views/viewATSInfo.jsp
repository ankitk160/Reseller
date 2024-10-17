<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>View App Traffic Service Info Details</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="robots" content="all,follow">
<style>
.table-container {
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	/* Use 100% of the viewport height to center vertically */
}

th, td {
	padding: 3px;
	text-align: center;
}
</style>
</head>
<body>
	<div class="table-container">
		<table>
			<tr>
				<th><h2>View App Traffic Service Info Details</h2></th>
			</tr>
			<tr>
				<th>App Traffic Service Info Id : ${dataList.id}</th>
			</tr>
			<tr>
				<td>Promoter Name : ${dataList.promoterName}</td>
			</tr>
			<tr>
				<td>Service Name : ${dataList.campaign_name}</td>
			</tr>
			<tr>
				<td>Country : ${dataList.country_name}</td>
			</tr>
			<tr>
				<td>Operator : ${dataList.operator_name}</td>
			</tr>
			<tr>
				<td>SUB SC : ${dataList.sub_sc}</td>
			</tr>
			<tr>
				<td>UNSUB SC : ${dataList.unsub_sc}</td>
			</tr>
			<tr>
				<td>UNSUB KW : ${dataList.keyword}</td>
			</tr>
			<tr>
				<td>PinLength : ${dataList.pinlength}</td>
			</tr>
			<tr>
				<td>Price : ${dataList.price}</td>
			</tr>
			<tr>
				<td>Validity : ${dataList.validity}</td>
			</tr>
		</table>
	</div>
</body>
</html>