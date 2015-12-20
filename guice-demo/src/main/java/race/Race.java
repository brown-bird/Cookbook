/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package race;

import java.util.List;

/**
 *
 * @author richardclay
 */
public interface Race
{
    public void enterContestants(List<Team> teams);
    public void startRace();
    public void endRace();
    public void printPositions();
    public String getWinner();
    public void getContestants();
}
