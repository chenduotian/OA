package com.example.mtelnet.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.androidquery.AQuery;

/**
 * Created by sundy on 15/7/30.
 */
public class BaseFragment extends Fragment implements View.OnClickListener {

    private final String TAG = "BaseFragment";
    protected OnBaseListener mCallback;
    protected FragmentActivity context;
    protected LayoutInflater inflater;
    protected AQuery aq;

    public BaseFragment() {
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (OnBaseListener) (context = (FragmentActivity) activity);
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnHeadlineSelectedListener");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        aq = new AQuery(getActivity());

    }

    public void saveCurrentSelectionItem(String menu_name, String sub_menu_name) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(MyConstant.APP_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(MyConstant.MENU_SELECTION, menu_name);
        editor.putString(MyConstant.SUB_MENU_SELECTION, sub_menu_name);
        editor.commit();
    }

    public String getCurrentSelectionItem() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(MyConstant.APP_NAME, Context.MODE_PRIVATE);
//        rtLog(TAG, "----------->当前选择的Menu =" + sharedPreferences.getString(MyConstant.MENU_SELECTION, ""));
        return sharedPreferences.getString(MyConstant.MENU_SELECTION, "");
    }

    public String getCurrentSubmenuSelectionItem() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(MyConstant.APP_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(MyConstant.SUB_MENU_SELECTION, "");
    }

    public void removeCurrentSelectionItem() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(MyConstant.APP_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(MyConstant.MENU_SELECTION);
        editor.remove(MyConstant.SUB_MENU_SELECTION);
        editor.commit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    // Container Activity must implement this interface
    public interface OnBaseListener {

        public void switchContent(android.support.v4.app.Fragment fragment, String tag);

        public void addContent(android.support.v4.app.Fragment fragment, String tag);

        public void showSlidingMenu();

        public void onBack();

        public void reloadActivity();

        public void switchContent(int rid);
    }

    @Override
    public void onClick(View view) {
        rtLog(TAG, "---------->onClick");
        if (mCallback == null)
            return;
        switch (view.getId()) {
           /* case R.id.btnMenu:
                AdobeLog.logEvent(AdobeLog.Action_left_menu, context);
                mCallback.showSlidingMenu();
                MyConstant.is_AdobeLog = false;
                break;
            case R.id.btnBack:
                rtLog(TAG, "---------->btnBack");
                mCallback.reloadActivity();
                mCallback.onBack();
                break;*/
        }
    }

    public void rtLog(String tag, String msg) {
        if (MyConstant.IsDebug) {
            Log.e(tag, msg);
        }
    }
    public boolean getCurrentFragment(String tag){
        android.app.Fragment fragment = getActivity().getFragmentManager().findFragmentByTag(tag);
        if (fragment != null && fragment.isVisible()) {
            return true;
        }else {
            return false;
        }
    }

    protected void onAnimationStarted () {}

    protected void onAnimationEnded () {}

   /* @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {

        if(enter && nextAnim == R.anim.slide_in_right) {
//            Log.i(TAG, "Animation slide in right");
            Animation anim = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_in_right);

            anim.setAnimationListener(new Animation.AnimationListener() {

                @Override
                public void onAnimationStart(Animation animation) {
//                    Log.d(TAG, "Animation started.");
                    onAnimationStarted();
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
//                    Log.d(TAG, "Animation repeating.");
                }

                @Override
                public void onAnimationEnd(Animation animation) {
//                    Log.d(TAG, "Animation ended.");
                    onAnimationEnded();
                }
            });

            return anim;
        }else{
//            Log.i(TAG, "Animation other");
            return super.onCreateAnimation(transit, enter, nextAnim);
        }
    }*/
}
