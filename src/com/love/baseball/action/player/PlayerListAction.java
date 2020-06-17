package com.love.baseball.action.player;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.love.baseball.action.Action;
import com.love.baseball.dto.PlayerListResponseDto;
import com.love.baseball.repository.PlayerRepository;
import com.love.baseball.util.Script;

public class PlayerListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int teamId = Integer.parseInt(request.getParameter("teamId"));
		
		PlayerRepository playerRepository = PlayerRepository.getInstance();
		List<PlayerListResponseDto> dtos = playerRepository.findByTeamId(teamId);
		
		Gson gson = new Gson();
		String toJson = gson.toJson(dtos);
		Script.outJson(toJson, response);
		
	}

}
