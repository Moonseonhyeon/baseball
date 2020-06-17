//////////////////////////teamList

function teamList(){
	$.ajax({
		type: "get",
		url: "/baseball/con?cmd=teamList",
		dataType: "json"
	}).done(function(result) {
		
		renderTeamList(result);		
	}).fail(function(error) {
		alert("실패..");
	});
}

function renderTeamList(teams){
	
	for(var team of teams){
		$("#team__list").append(makeTeamList(team));
	}
}

function makeTeamList(team){
	var html = `<tr>`;
	html += `<td>${team.teamId}</td>`;
	html += `<td onclick="playerList(${team.teamId})">${team.teamName}</td>`;
	html += `</tr>`;
	
		return html;
}

// ////////////////////////////////playerList

function playerList(teamId){
	// alert(teamId);
	$.ajax({
		type: "post",
		url: "/baseball/con?cmd=playerList",
		data: "teamId="+teamId,
		contentType: "application/x-www-form-urlencoded; charset=utf-8",
		dataType: "json"		
		
	}).done(function(result){
		$("#player__list").empty();
		$("#player_info").empty();
		renderPlayerList(result);
	}).fail(function(error){
		alert("실패");
	});
}

function renderPlayerList(dtos){
	for(var dto of dtos){		
		$("#player__list").append(makePlayerList(dto));
	}
}

function makePlayerList(dto){
	var html = `<tr>`;
	html += `<td>${dto.playerId}</td>`;
	html += `<td onclick="playerInfo(${dto.playerId})">${dto.name}</td>`;
	html += `</tr>`;
	
		return html;
}


// //////////////////////////////playerInfo

function playerInfo(playerId){
	//alert(playerId);
	$.ajax({
		type: "post",
		url: "/baseball/con?cmd=playerInfo",
		data: "playerId="+playerId,
		contentType: "application/x-www-form-urlencoded; charset=utf-8",
		dataType: "json"		
		
	}).done(function(result){		
		$("#player_info").empty();
		renderPlayerInfo(result);
	}).fail(function(error){
		alert("실패");
	});
}

function renderPlayerInfo(player){	
		$("#player_info").append(makePlayerInfo(player));	
}

function makePlayerInfo(player){
	var html = `<tr>`;
	html += `<td>${player.playerId}</td>`;
	html += `<td>${player.name}</td>`;
	html += `<td>${player.position}</td>`;
	html += `</tr>`;
	
		return html;
}

