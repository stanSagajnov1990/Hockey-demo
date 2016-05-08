<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
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
#table_info th {
    padding: 5px;
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
			<span
				style="font-size: 35px; font-family: Sintony; font-weight: bold; margin-top: 10px; margin-left: auto; margin-right: auto; display: block; width: auto;">
				${player.name } | #${player.number} </span> <span
				style="font-size: 20px; font-weight: bold; color: #868686; display: block; margin-top: 10px;">
				${player.position } | ${player.weight} lb | Age: ${player.age } |
				${player.team.name }</span>
		</div>
	</div>
	<div style="padding: 20px; border-top: thick solid #C0C0C0;">
		<div id="personal_info" style="width:40%; float: left; display: inline-block;">
			<span style="display: inline-block;"><b>${ player.name}</b></span> 
			<span style="display: block;"><b>Born: </b>${player.birthdate }</span> 
			<span style="display: block;"><b>Birthplace: </b>${player.birthplace }</span>
		</div>
		<div id="table_info" style="display: inline-block;">
			<table>
				<thead>
					<tr style="color:white;background-color: black;">
						<th><span>Season</span></th>
						<th><span>GP</span></th>
						<th><span>G</span></th>
						<th><span>A</span></th>
						<th><span>P</span></th>
					</tr>
				</thead>
				<tbody>
					<tr>	
						<th>
							<span>2015-2016 Playoffs</span>
						</th>
						<th>
							<span>7</span>
						</th>
						<th>
							<span>1</span>
						</th>
						<th>
							<span>6</span>
						</th>
						<th>
							<span>7</span>
						</th>
					</tr>
					<tr>	
						<th>
							<span>Career Playoffs</span>
						</th>
						<th>
							<span>123</span>
						</th>
						<th>
							<span>49</span>
						</th>
						<th>
							<span>72</span>
						</th>
						<th>
							<span>121</span>
						</th>
					</tr>
					<tr>
						<th>
							<span>2015-2016</span>
						</th>
						<th>
							<span>79</span>
						</th>
						<th>
							<span>50</span>
						</th>
						<th>
							<span>21</span>
						</th>
						<th>
							<span>71</span>
						</th>
					</tr>
					<tr>
						<th>
							<span>NHL Career</span>
						</th>
						<th>
							<span>658</span>
						</th>
						<th>
							<span>251</span>
						</th>
						<th>
							<span>412</span>
						</th>
						<th>
							<span>663</span>
						</th>
					</tr>
				</tbody>
			</table>
		
		</div>

	</div>

</body>
</html>