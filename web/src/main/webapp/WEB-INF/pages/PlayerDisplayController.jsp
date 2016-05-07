<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${player.name}</title>
<style type="text/css">
body{
	font-family: Sintony;
}

</style>

</head>
<body style="margin: 0px">

	<div style="background: black;">
		<img src="${player.bigImageUrl }"
			style="margin-left: auto; margin-right: auto; display: block;" />
	</div>
	<div style="position: relative; top: -100px">
		<div style="margin-left: auto; margin-right: auto; width: 450px;">
			<img src="${player.imageUrl }"
				style="border-radius: 50%; display: block; margin-left: auto; margin-right: auto; display: block; margin-left: auto; margin-right: auto;" />
			<span style="font-size: 35px; font-family: Sintony; font-weight: bold; margin-top:10px;margin-left: auto; margin-right: auto; display:block;width:auto;">
				${player.name } | #${player.number} </span> 
				<span style="font-size: 20px; font-weight: bold; color: #868686; display: block; margin-top:10px;">
				${player.position } | ${player.weight} lb | Age: ${player.age } |
				${player.team.name }</span>
		</div>
	</div>
</body>
</html>