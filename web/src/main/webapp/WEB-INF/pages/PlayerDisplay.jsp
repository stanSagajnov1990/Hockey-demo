<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${player.name}</title>
<style type="text/css">
body {
	font-family: Sintony;
}

#personal_info span {
	padding: 5px;
	font-size: 20px;
}

#table_info span {
	padding: 10px;
	font-size: 20px;
}

#table_info th, td {
	padding: 5px;
}
</style>

</head>
<body style="margin: 0px">
	<div>
		
	</div>
	<div>
		<a style="">
			<img src="<spring:url value="/resources/img/nhl_logo.png"/>" height="60"/>
			NHL
			</a>
	</div>
	<div style="background: black;">
		<img src="${player.bigImageUrl }"
			style="margin-left: auto; margin-right: auto; display: block;" />
	</div>
	<div style="position: relative; top: -100px">
		<div style="margin-left: auto; margin-right: auto; width: 450px;">
			<img src="${player.imageUrl }"
				style="border-radius: 50%; display: block; margin-left: auto; margin-right: auto; display: block; margin-left: auto; margin-right: auto;" />
			<span
				style="font-size: 35px; font-family: Sintony; font-weight: bold; margin-top: 10px; margin-left: auto; margin-right: auto; display: block; width: auto;">
				${player.name } | #${player.number} </span> <span
				style="font-size: 20px; font-weight: bold; color: #868686; display: block; margin-top: 10px;">
				${player.position } | ${player.formattedHeight} | ${player.weight}
				lb | Age: ${player.age } | ${player.team.name }</span>
		</div>
	</div>
	<div style="padding: 20px; border-top: thick solid #C0C0C0;">
		<div id="personal_info"
			style="width: 35%; float: left; display: inline-block;">
			<span style="display: inline-block;"><b>${ player.name}</b></span> <span
				style="display: block;"><b>Born: </b>${player.birthdate }</span> <span
				style="display: block;"><b>Birthplace: </b>${player.birthplace }</span>
		</div>
		<div id="table_info" style="display: inline-block;">
			<table>
				<thead>
					<tr style="color: white; background-color: black;">
						<th><span>Season</span></th>
						<th><span>GP</span></th>
						<th><span>G</span></th>
						<th><span>A</span></th>
						<th><span>P</span></th>
						<th><span>+/-</span></th>
						<th><span>PIM</span></th>
						<th><span>PPG</span></th>
						<th><span>PPP</span></th>
						<th><span>SHG</span></th>
						<th><span>SHP</span></th>
						<th><span>GWG</span></th>
						<th><span>OTG</span></th>
						<th><span>S</span></th>
						<th><span>S%</span></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><span>2015-2016 Playoffs</span></td>
						<td><span>${playoffStatistics.gamesPlayed }</span></td>
						<td><span>${playoffStatistics.goals }</span></td>
						<td><span>${playoffStatistics.assists }</span></td>
						<td><span>${playoffStatistics.points }</span></td>
						<td><span>${playoffStatistics.plusminus }</span></td>
						<td><span>${playoffStatistics.penaltyInMinutes }</span></td>
						<td><span>${playoffStatistics.powerPlayGoals }</span></td>
						<td><span>${playoffStatistics.powerPlayPoints }</span></td>
						<td><span>${playoffStatistics.shortHandedGoals }</span></td>
						<td><span>${playoffStatistics.shortHandedPoints }</span></td>
						<td><span>${playoffStatistics.gameWinningGoals }</span></td>
						<td><span>${playoffStatistics.overtimeGoals }</span></td>
						<td><span>${playoffStatistics.shots }</span></td>
						<td><span>${playoffStatistics.shotPercentage }</span></td>
					</tr>
					<tr>
						<td><span>Career Playoffs</span></td>
						<td><span>${sumOfPlayoffs[0]}</span></td>
						<td><span>${sumOfPlayoffs[1]}</span></td>
						<td><span>${sumOfPlayoffs[2]}</span></td>
						<td><span>${sumOfPlayoffs[3]}</span></td>
						<td><span>${sumOfPlayoffs[4]}</span></td>
						<td><span>${sumOfPlayoffs[5]}</span></td>
						<td><span>${sumOfPlayoffs[6]}</span></td>
						<td><span>${sumOfPlayoffs[7]}</span></td>
						<td><span>${sumOfPlayoffs[8]}</span></td>
						<td><span>${sumOfPlayoffs[9]}</span></td>
						<td><span>${sumOfPlayoffs[10]}</span></td>
						<td><span>${sumOfPlayoffs[11]}</span></td>
						<td><span>${sumOfPlayoffs[12]}</span></td>
						<%
							//TODO round up to 2 decimal points
						%>
						<td><span>${sumOfPlayoffs[13]}</span></td>
					</tr>
					<tr>
						<td><span>2015-2016</span></td>
						<td><span>${seasonStatistics.gamesPlayed }</span></td>
						<td><span>${seasonStatistics.goals }</span></td>
						<td><span>${seasonStatistics.assists }</span></td>
						<td><span>${seasonStatistics.points }</span></td>
						<td><span>${seasonStatistics.plusminus }</span></td>
						<td><span>${seasonStatistics.penaltyInMinutes }</span></td>
						<td><span>${seasonStatistics.powerPlayGoals }</span></td>
						<td><span>${seasonStatistics.powerPlayPoints }</span></td>
						<td><span>${seasonStatistics.shortHandedGoals }</span></td>
						<td><span>${seasonStatistics.shortHandedPoints }</span></td>
						<td><span>${seasonStatistics.gameWinningGoals }</span></td>
						<td><span>${seasonStatistics.overtimeGoals }</span></td>
						<td><span>${seasonStatistics.shots }</span></td>
						<td><span>${seasonStatistics.shotPercentage }</span></td>
					</tr>
					<tr>
						<td><span>NHL Career</span></td>
						<td><span>${sumOfSeasons[0]}</span></td>
						<td><span>${sumOfSeasons[1]}</span></td>
						<td><span>${sumOfSeasons[2]}</span></td>
						<td><span>${sumOfSeasons[3]}</span></td>
						<td><span>${sumOfSeasons[4]}</span></td>
						<td><span>${sumOfSeasons[5]}</span></td>
						<td><span>${sumOfSeasons[6]}</span></td>
						<td><span>${sumOfSeasons[7]}</span></td>
						<td><span>${sumOfSeasons[8]}</span></td>
						<td><span>${sumOfSeasons[9]}</span></td>
						<td><span>${sumOfSeasons[10]}</span></td>
						<td><span>${sumOfSeasons[11]}</span></td>
						<td><span>${sumOfSeasons[12]}</span></td>
						<%
							//TODO round up to 2 decimal points
						%>
						<td><span>${sumOfSeasons[13]}</span></td>
					</tr>
				</tbody>
			</table>

		</div>

	</div>

</body>
</html>