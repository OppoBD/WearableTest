package com.dulife.test;

import com.robotium.solo.Solo;
import junit.framework.TestCase;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;

@SuppressWarnings("unchecked")
public class version_2_0_0 extends ActivityInstrumentationTestCase2 {

	private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "com.baidu.wearable.ui.activities.WelcomeActivity";
	private static Class launcherActivityClass;
	static {

		try {
			launcherActivityClass = Class
					.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public version_2_0_0() throws ClassNotFoundException {
		super(launcherActivityClass);
	}

	private Solo solo;

	@Override
	protected void setUp() throws Exception {
		solo = new Solo(getInstrumentation(), getActivity());
	}

	public void testLogin() {
		solo.clickOnText("同意");
		solo.sleep(5000);
//		//向左滑动3次
		for(int i =0 ;i < 3; i++) {
			solo.scrollToSide(22);
			solo.sleep(1000);
		}		
		// Enter any integer/decimal value for first editfield, we are writing  10
		solo.clearEditText(0);
		solo.enterText(0, "liwei05test03");
//		
//		// Enter any integer/decimal value for first editfield, we are writing  20
		solo.clearEditText(1);
		solo.enterText(1, "qaz123");
//		
//		// Click on Multiply button
		int id = solo.getCurrentActivity().getResources().getIdentifier("login", "id", "com.baidu.wearable");
		View v = solo.getView(id);
		solo.clickOnView(v);
		solo.waitForText("我");
//
//		//如果有新版本，就取消下载
		solo.waitForText("新版本");
		if(solo.searchText("新版本"))
			solo.clickOnText("取消");
		solo.sleep(2000);
		

		if(solo.searchText("我"))
			solo.clickOnText("我");		
		// Verify that resultant of 10 x 20
//		assertTrue(solo.searchText("liwei05test03"));
		assertTrue(solo.searchText("步数"));
		
	}
	
//	public void testSettings() {
//		//点击设置
//		int id_settings = solo.getCurrentActivity().getResources().getIdentifier("main_settings", "id", "com.baidu.wearable");
//		View v_settings = solo.getView(id_settings);
//		solo.clickOnView(v_settings);
//		solo.sleep(1000);
//		
//		solo.clickOnText("久坐提醒");
//		solo.sleep(500);
//		int id_lost = solo.getCurrentActivity().getResources().getIdentifier("my_phone_anti_lost_switch_layout", "id", "com.baidu.wearable");
//		View v_lost = solo.getView(id_lost);
//		solo.clickOnView(v_lost);
//		solo.sleep(2000);
//	}

	@Override
	public void tearDown() throws Exception {
		solo.finishOpenedActivities();
	}

}