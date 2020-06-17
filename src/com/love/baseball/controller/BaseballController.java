package com.love.baseball.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.love.baseball.action.Action;
import com.love.baseball.action.player.PlayerInfoAction;
import com.love.baseball.action.player.PlayerListAction;
import com.love.baseball.action.team.TeamListAction;


@WebServlet("/con")
public class BaseballController extends HttpServlet {
	private static final String TAG = "BaseballController : ";
	private static final long serialVersionUID = 1L;
    
    public BaseballController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		System.out.println(TAG+"router : "+cmd);
		Action action = router(cmd);
		action.execute(request, response);
	}
	
	public Action router(String cmd) {
		if(cmd.equals("teamList")) {
			return new TeamListAction();
		}else if(cmd.equals("playerList")) {
			return new PlayerListAction();
		}else if(cmd.equals("playerInfo")) {
			return new PlayerInfoAction();
		}
		return null;
	}
	

}
