package com.cyberdust.automation.elements;

public class TestAccounts {

	public static boolean accountSet1;
	public static boolean accountSet2;
	
	/**************************
	 * Account variable names *
	 **************************/
	
	// AccountManagementTest //
	public String acctmgnt_account01;
	public String acctmgnt_password01;
	
	public String accmgnt_email;
	public String accmgnt_new_email;
	public String accmgnt_new_password;
	
	// AddFriendsTest //
	public String addfriend_account01;
	public String addfriend_password01;
	public String addfriend_account02;
	public String addfriend_password02;
	
	public String addfriend_email;
	
	// BlastTest //
	public String blasts_account01;
	public String blasts_password01;

	public String blasts_account02;
	public String blasts_password02;

	public String blasts_account03;
	public String blasts_password03;
	
	// DeleteGroupChatTest //
	public String deletegroup_account;
	public String deletegroup_password;
	
	public String deletegroup_account01;
	public String deletegroup_password01;
	
	public String deletegroup_account02;
	public String deletegroup_password02;
	
	public String deletegroup_account03;
	public String deletegroup_password03;
	
	public String deletegroup_account04;
	public String deletegroup_password04;
	
	public String deletegroup_account05;
	public String deletegroup_password05;
	
	// DustTest //
	public String dusts_account01;
	public String dusts_password01;
	
	public String dusts_account02;
	public String dusts_password02;
	
	public String dusts_account03;
	public String dusts_password03;
	
	public String dusts_email;
	
	// FindTest //
	public String find_account01;
	public String find_password01;
	
	// FollowersTest //
	public String followers_account01;
	public String followers_password01;
	
	public String followers_account02;
	public String followers_password02;
	
	// FriendTest //
	public String friends_account01;
	public String friends_password01;
	
	public String friends_account02;
	public String friends_password02;
		
	public String friends_account03;
	public String friends_password03;
	
	public String friends_account04;
	public String friends_password04;
	
	public String friends_account05;
	public String friends_password05;
	
	public String friends_account06;
	public String friends_password06;
	
	// GroupTest //
	public String groups_account01;
	public String groups_password01;

	public String groups_account02;
	public String groups_password02;

	public String groups_account03;
	public String groups_password03;
	
	public String groups_blocked_account;
	public String groups_blocked_password;
	
	// MessagePinningTest //
	public String pin_account01;
	public String pin_password01;
	
	public String pin_account02;
	public String pin_password02;
	
	// MyBlastsTest //
	public String myblasts_account01;
	public String myblasts_password01;
	
	public String myblasts_account02;
	public String myblasts_password02;
	
	// ReblastTest //
	public String reblast_account01;
	public String reblast_password01;
	
	public String reblast_account02;
	public String reblast_password02;
	
	public String reblast_account03;
	public String reblast_password03;
	
	// SignUpTest //
	public String signup_account;
	public String signup_password;
	public String signup_email;
	
	// TimeoutTest //
	public String timeout_account;
	public String timeout_password;
	
	public String timeout_account01;
	public String timeout_password01;
	
	public String timeout_account02;
	public String timeout_password02;
	
	public String timeout_account03;
	public String timeout_password03;
	
	public String timeout_account04;
	public String timeout_password04;
	
	public String timeout_account05;
	public String timeout_password05;
	
	// TimestampTest //
	public String timestamp_account;
	public String timestamp_password;
	
	public String timestamp_account01;
	public String timestamp_password01;
	
	public String timestamp_account02;
	public String timestamp_password02;
	
	// TutorialTest //
	public String tutorial_account;
	public String tutorial_password;
	
	// URLShortenerTest //
	public String url_account;
	public String url_password;
	public String url_email; 
	
	{
		
	/*****************
	 * Account Set 1 *
	 *****************/

	if ((!accountSet1 && !accountSet2) || accountSet1) {
		// AccountManagement //
		acctmgnt_account01 = "acctmgnt";
		acctmgnt_password01 = "password";
		accmgnt_new_password = "new password";
		accmgnt_email = "testuser_03@cyberdust.com";
		accmgnt_new_email = "new_testuser_03@cyberdust.com";

		// AddFriends //
		addfriend_account01 = "addfriends";
		addfriend_password01 = "password";
		addfriend_account02 ="friends1";
		addfriend_password02 = "password";
		addfriend_email = "existing02@cyberdust.com";

		// Blasts //
		blasts_account01 = "blasttest01";
		blasts_password01 = "blasttest01";

		blasts_account02 = "blasttest02";
		blasts_password02 = "blasttest02";

		blasts_account03 = "blasttest03";
		blasts_password03 = "blasttest03";

		// DeleteGroupChat //
		deletegroup_account = "deletegroupchatroom";
		deletegroup_password = "password";

		deletegroup_account01 = "testaccount01";
		deletegroup_password01 = "password";

		deletegroup_account02 = "testaccount02";
		deletegroup_password02 = "password";

		// Dusts //
		dusts_account01 = "dusttest";
		dusts_password01 = "password";

		dusts_account02 = "dustfriend1";
		dusts_password02 = "password";

		dusts_account03 = "dustfriend2";
		dusts_password03 = "password";

		dusts_email = "existing02@cyberdust.com";

		// Find //
		find_account01 = "findtester";
		find_password01 = "password";

		// Followers //
		followers_account01 = "followerstest";
		followers_password01 = "password";

		followers_account02 = "followerstestfriend";
		followers_password02 = "password";

		// Friends //
		friends_account01 = "friendtest01";
		friends_password01 = "friendtest01";

		friends_account02 = "friendtest02";
		friends_password02 = "friendtest02";

		friends_account03 = "friendtest03";
		friends_password03 = "friendtest03";

		friends_account04 = "friendtest04";
		friends_password04 = "friendtest04";

		friends_account05 = "friendtest05";
		friends_password05 = "friendtest05";

		friends_account06 = "friendtest06";
		friends_password06 = "friendtest06";

		// Groups //
		groups_account01 = "grouptest01";
		groups_password01 = "grouptest01";

		groups_account02 = "grouptest02";
		groups_password02 = "grouptest02";

		groups_account03 = "grouptest03";
		groups_password03 = "grouptest03";

		groups_blocked_account = "grouptest04";
		groups_blocked_password = "grouptest04";

		// MessagePinning
		pin_account01 = "messagepinning";
		pin_password01 = "password";

		pin_account02 = "messagepinningfriend";
		pin_password02 = "password";

		// MyBlasts //
		myblasts_account01 = "myblaststest01";
		myblasts_password01 = "myblaststest01";

		myblasts_account02 = "myblaststest02";
		myblasts_password02 = "myblaststest02";

		// Reblast //
		reblast_account01 = "blasttest01";
		reblast_password01 = "blasttest01";

		reblast_account02 = "blasttest02";
		reblast_password02 = "blasttest02";

		reblast_account03 = "blasttest03";
		reblast_password03 = "blasttest03";

		// SignUp //
		signup_account = "onboarding001";
		signup_password = "onboarding001";
		signup_email = "onboarding001@cyberdust.com";

		// Timeout //
		timeout_account = "timeouttest";
		timeout_password = "password";

		timeout_account01 = "timeoutfriend1";
		timeout_password01 = "password";

		timeout_account02 = "timeoutfriend2";
		timeout_password02 = "password";

		timeout_account03 = "timeoutfriend3";
		timeout_password03 = "password";

		timeout_account04 = "timeoutfriend4";
		timeout_password04 = "password";

		timeout_account05 = "timeoutfriend5";
		timeout_password05 = "password";

		// Timestamp //
		timestamp_account = "timestamptest";
		timestamp_password = "password";

		timestamp_account01 = "timestamptestfriend";
		timestamp_password01 = "password";

		timestamp_account02 = "timestampfriend2";
		timestamp_password02 = "password";

		// Tutorial //
		tutorial_account = "tutorialtest";
		tutorial_password = "password";

		// URLShortener //
		url_account = "urlshorttest";
		url_password = "password";
		url_email = "new_existing@cyberdust.com";
	}
	
	/*****************
	 * Account Set 2 *
	 *****************/

	if (accountSet2) {
		// AccountManagement //
		acctmgnt_account01 = "acctmgnt";
		acctmgnt_password01 = "password";
		accmgnt_new_password = "new password";
		accmgnt_email = "testuser_04@cyberdust.com";
		accmgnt_new_email = "new_testuser_04@cyberdust.com";
		
		// AddFriends //
		addfriend_account01 = "addfriends";
		addfriend_password01 = "password";
		
		addfriend_email = "existing02@cyberdust.com";
		
		// Blasts //
		blasts_account01 = "blasttest21";
		blasts_password01 = "blasttest21";

		blasts_account02 = "blasttest22";
		blasts_password02 = "blasttest22";

		blasts_account03 = "blasttest23";
		blasts_password03 = "blasttest23";
		
		// DeleteGroupChat //
		deletegroup_account = "deletegroupchatroom";
		deletegroup_password = "password";
		
		deletegroup_account01 = "testaccount01";
		deletegroup_password01 = "password";
		
		deletegroup_account02 = "testaccount02";
		deletegroup_password02 = "password";
		
		deletegroup_account03 = "testaccount03";
		deletegroup_password03 = "password";
		
		deletegroup_account04 = "testaccount04";
		deletegroup_password04 = "password";
		
		deletegroup_account05 = "testaccount05";
		deletegroup_password05 = "password";
		
		// Dusts //
		dusts_account01 = "dusttest";
		dusts_password01 = "password";
		
		dusts_account02 = "dustfriend1";
		dusts_password02 = "password";
		
		dusts_account03 = "dustfriend2";
		dusts_password03 = "password";
		
		dusts_email = "existing02@cyberdust.com";
		
		// Find //
		find_account01 = "findtester";
		find_password01 = "password";
		
		// Followers //
		followers_account01 = "followerstest";
		followers_password01 = "password";
		
		followers_account02 = "followerstestfriend";
		followers_password02 = "password";
		
		// Friends //
		friends_account01 = "friendtest21";
		friends_password01 = "friendtest21";
		
		friends_account02 = "friendtest22";
		friends_password02 = "friendtest22";
			
		friends_account03 = "friendtest23";
		friends_password03 = "friendtest23";
		
		friends_account04 = "friendtest24";
		friends_password04 = "friendtest24";
		
		friends_account05 = "friendtest25";
		friends_password05 = "friendtest25";
		
		friends_account06 = "friendtest26";
		friends_password06 = "friendtest26";
		
		// Groups //
		groups_account01 = "grouptest21";
		groups_password01 = "grouptest21";

		groups_account02 = "grouptest22";
		groups_password02 = "grouptest22";

		groups_account03 = "grouptest23";
		groups_password03 = "grouptest23";
		
		groups_blocked_account = "grouptest24";
		groups_blocked_password = "grouptest24";
		
		// MessagePinning //
		pin_account01 = "messagepinning";
		pin_password01 = "password";
		
		pin_account02 = "messagepinningfriend";
		pin_password02 = "password";
		
		// MyBlasts //
		myblasts_account01 = "myblaststest21";
		myblasts_password01 = "myblaststest21";
		
		myblasts_account02 = "myblaststest22";
		myblasts_password02 = "myblaststest22";
		
		// Reblast //
		reblast_account01 = "blasttest21";
		reblast_password01 = "blasttest21";
		
		reblast_account02 = "blasttest22";
		reblast_password02 = "blasttest22";
		
		reblast_account03 = "blasttest23";
		reblast_password03 = "blasttest23";
		
		// SignUp //
		signup_account = "onboarding002";
		signup_password = "onboarding002";
		signup_email = "onboarding002@cyberdust.com";
		
		// Timeout //
		timeout_account = "timeouttest";
		timeout_password = "password";
		
		timeout_account01 = "timeoutfriend1";
		timeout_password01 = "password";
		
		timeout_account02 = "timeoutfriend2";
		timeout_password02 = "password";
		
		timeout_account03 = "timeoutfriend3";
		timeout_password03 = "password";
		
		timeout_account04 = "timeoutfriend4";
		timeout_password04 = "password";
		
		timeout_account05 = "timeoutfriend5";
		timeout_password05 = "password";
		
		// Timestamp //
		timestamp_account = "timestamptest";
		timestamp_password = "password";
		
		timestamp_account01 = "timestamptestfriend";
		timestamp_password01 = "password";
		
		timestamp_account02 = "timestampfriend2";
		timestamp_password02 = "password";
		
		// Tutorial //
		tutorial_account = "tutorialtest";
		tutorial_password = "password";
		
		// URLShortener //
		url_account = "urlshorttest";
		url_password = "password";
		url_email = "new_existing@cyberdust.com";
	}
	
	}
}