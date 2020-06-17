<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<link href="/baseball/css/myStyle.css" rel="stylesheet">
<title>baseball</title>
</head>
<body onload="teamList()">
	<div class="container">
		<div class="row">
		
			<div class="col-sm-3">
			<br/>
			<h2>팀 목록</h2>
				<table class="table table-dark table-striped">
					<thead>
						<tr>
							<th>팀번호</th>
							<th>팀이름</th>
						</tr>
					</thead>
					<tbody id="team__list">

					</tbody>
				</table>
			</div>

			<div class="col-sm-3">
			<br/>
			<h2>선수 목록</h2>
				<table class="table table-dark table-striped">
					<thead>
						<tr>
							<th>선수번호</th>
							<th>선수이름</th>
						</tr>
					</thead>
					<tbody id="player__list">

					</tbody>
				</table>
			</div>

			<div class="col-sm-6">
			<br/>
			<h2>선수 정보</h2>
				<table class="table table-dark table-striped">
					<thead>
						<tr>
							<th>선수번호</th>
							<th>선수이름</th>
							<th>포지션</th>
						</tr>
					</thead>
					<tbody id="player_info">
						
					</tbody>
				</table>
			</div>
			
		</div>
	</div>
	<script src="/baseball/js/list.js"></script>
</body>
</html>