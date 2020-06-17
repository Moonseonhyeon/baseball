package com.love.baseball.action.player;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.love.baseball.action.Action;
import com.love.baseball.model.Player;
import com.love.baseball.repository.PlayerRepository;
import com.love.baseball.util.Script;

public class PlayerInfoAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int playerId = Integer.parseInt(request.getParameter("playerId"));

		PlayerRepository playerRepository = PlayerRepository.getInstance();
		Player player = playerRepository.findByPlayerId(playerId);

		Gson gson = new Gson();
		String toJson = gson.toJson(player);
		Script.outJson(toJson, response);

	}

}
