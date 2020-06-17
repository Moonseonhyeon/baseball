package com.love.baseball.action.team;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.love.baseball.action.Action;
import com.love.baseball.model.Team;
import com.love.baseball.repository.TeamRepository;
import com.love.baseball.util.Script;



public class TeamListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TeamRepository teamRepository = TeamRepository.getInstance();
		List<Team> teams = teamRepository.findTeamAll();
		
		Gson gson = new Gson();
		String toJson = gson.toJson(teams);
		Script.outJson(toJson, response);		
		
	}

}
