<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${player.name}</title>
<link href="<spring:url value="/resources/css/style.css"/>" rel="stylesheet" />
</head>
<body>
	<div>
		<c:forEach var="listEntry" items="${games}">
			<div style="padding: 10px; border: 1px solid black; display: inline-block; width: auto;padding-right:25px;">
				<div class="team_logo">
					<c:out value="${listEntry.homeTeam.logoSmallAsString}" escapeXml="false"/>
				</div>
				<span style="vertical-align: super;position:relative; top: -3px;">
					<c:out value="${fn:toUpperCase(listEntry.homeTeam.token)}" />
				</span> 
				<span class="score">
					<c:out value="${listEntry.homeTeamScore}" /> 
				</span>
				<br>
				<div class="team_logo">
					<c:out value="${listEntry.awayTeam.logoSmallAsString}" escapeXml="false"/>
				</div>
				<span style="vertical-align: super;position:relative; top: -3px;">
					<c:out value="${fn:toUpperCase(listEntry.awayTeam.token)}" />
				</span> 
				<span class="score">
					<c:out value="${listEntry.awayTeamScore}" /> 
				</span>
			</div>
		</c:forEach>
	</div>
	<div>
		<a> <img src="<spring:url value="/resources/img/nhl_logo.png"/>" height="60" /> 
			NHL
		</a>
	</div>
	<div id="player-stage">
		<!-- <div style="background-image: url('${player.bigImageUrl }');margin-left: auto; margin-right: auto; display: block;" ></div>-->
		<img id="player-foto" src="${player.bigImageUrl }" />
	</div>
	<div id="player-info">
		<div>
			<img id="player-image" src="${player.imageUrl }" />
			<span id="player-name">
				${player.name } | #${player.number} 
			</span> 
			<span id="player-secondLine">
				${player.position } | ${player.formattedHeight} | ${player.weight} lb | Age: ${player.age } | ${player.team.name }
			</span>
		</div>
	</div>
	<div id="player-addInfo">
		<div id="personal_info">
			<span style=""><b>${ player.name}</b></span><br> 
			<span style=""><b>Born: </b>${player.birthdate }</span><br> 
			<span style=""><b>Birthplace: </b>${player.birthplace }</span>
		</div>
		<div id="table_info">
			<table>
				<thead style="color: white; background-color: black;">
					<tr >
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