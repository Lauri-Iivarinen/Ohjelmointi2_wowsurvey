package model;

public class Kysely {
	private int id;
	private String nickname;
    private int hoursplayed;
    private String progressdiff;
    private int progressnum;
    private String favboss;
    private int mplus;
    private boolean playpvp;
    private String removeclass;
    private String whyremove;
    private boolean expachype;
    
    
    //CONSTRUCTORS
    
    public Kysely(int id, String nickname, int hoursplayed, String progressdiff, int progressnum, String favboss, int mplus,
			boolean playpvp, String removeclass, String whyremove, boolean expachype) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.hoursplayed = hoursplayed;
		this.progressdiff = progressdiff;
		this.progressnum = progressnum;
		this.favboss = favboss;
		this.mplus = mplus;
		this.playpvp = playpvp;
		this.removeclass = removeclass;
		this.whyremove = whyremove;
		this.expachype = expachype;
	}
    
    public Kysely() {
    	
    }
    
	//SETTERS
    
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public void setHoursplayed(int hoursplayed) {
		this.hoursplayed = hoursplayed;
	}
	public void setProgressdiff(String progressdiff) {
		this.progressdiff = progressdiff;
	}
	public void setProgressnum(int progressnum) {
		this.progressnum = progressnum;
	}
	public void setFavboss(String favboss) {
		this.favboss = favboss;
	}
	public void setMplus(int mplus) {
		this.mplus = mplus;
	}
	public void setPlaypvp(boolean playpvp) {
		this.playpvp = playpvp;
	}
	public void setRemoveclass(String removeclass) {
		this.removeclass = removeclass;
	}
	public void setWhyremove(String whyremove) {
		this.whyremove = whyremove;
	}
	public void setExpachype(boolean expachype) {
		this.expachype = expachype;
	}
	
	//GETTERS
	
	public int getId() {
		return id;
	}
	
	public String getNickname() {
		return nickname;
	}
	public int getHoursplayed() {
		return hoursplayed;
	}
	public String getProgressdiff() {
		return progressdiff;
	}
	public int getProgressnum() {
		return progressnum;
	}
	public String getFavboss() {
		return favboss;
	}
	public int getMplus() {
		return mplus;
	}
	public boolean isPlaypvp() {
		return playpvp;
	}
	public String getRemoveclass() {
		return removeclass;
	}
	public String getWhyremove() {
		return whyremove;
	}
	public boolean isExpachype() {
		return expachype;
	}
	
	
	
	@Override
	public String toString() {
		return "Kysely [id=" + id + ", nickname=" + nickname + ", hoursplayed=" + hoursplayed + ", progressdiff=" + progressdiff
				+ ", progressnum=" + progressnum + ", favboss=" + favboss + ", mplus=" + mplus + ", playpvp=" + playpvp
				+ ", removeclass=" + removeclass + ", whyremove=" + whyremove + ", expachype=" + expachype + "]";
	}
	
	
}
