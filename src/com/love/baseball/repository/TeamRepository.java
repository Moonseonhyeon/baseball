package com.love.baseball.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.love.baseball.db.DBConn;
import com.love.baseball.model.Team;

public class TeamRepository {
	private static final String TAG = "TeamRepository : ";
	private static TeamRepository instance = new TeamRepository();
	public TeamRepository() {	}
	public static TeamRepository getInstance() {
		return instance;
	}
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public List<Team> findTeamAll() {
		final String SQL = "SELECT * FROM team";// 쿼리문

		List<Team> teams = new ArrayList<>();
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			// 물음표 완성

			// while돌려서 rs오브젝트에 집어넣기
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Team team = new Team(rs.getInt("teamId"),
						rs.getString("teamName"));						
				teams.add(team);
			}
			return teams;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "findTeamAll : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		return null;
	}
}
