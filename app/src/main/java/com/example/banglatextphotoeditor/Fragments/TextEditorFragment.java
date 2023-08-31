package com.example.banglatextphotoeditor.Fragments;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.hitomi.cslibrary.CrazyShadow;
import com.jblabs.lipiyon.C1068R;
import com.jblabs.lipiyon.fragments.QuotesFragment;
import java.util.Objects;
import java.util.Random;

public class TextEditorFragment extends Fragment implements View.OnClickListener, QuotesFragment.QuotesFragmentListener {
    EditText editText;
    int[] quotes = {R.string.quotes1, R.string.quotes2, R.string.quotes3, R.string.quotes4, R.string.quotes5, C1068R.string.quotes6, C1068R.string.quotes7, C1068R.string.quotes8, C1068R.string.quotes9, C1068R.string.quotes10, C1068R.string.quotes11, C1068R.string.quotes12, C1068R.string.quotes13, C1068R.string.quotes14, C1068R.string.quotes15, C1068R.string.quotes16, C1068R.string.quotes17, C1068R.string.quotes18, C1068R.string.quotes19, C1068R.string.quotes20, C1068R.string.quotes21, C1068R.string.quotes22, C1068R.string.quotes23, C1068R.string.quotes24, C1068R.string.quotes25, C1068R.string.quotes26, C1068R.string.quotes27, C1068R.string.quotes28, C1068R.string.quotes29, C1068R.string.quotes30, C1068R.string.quotes31, C1068R.string.quotes32, C1068R.string.quotes33, C1068R.string.quotes34, C1068R.string.quotes35, C1068R.string.quotes36, C1068R.string.quotes37, C1068R.string.quotes38, C1068R.string.quotes39, C1068R.string.quotes40, C1068R.string.quotes41, C1068R.string.quotes42, C1068R.string.quotes43, C1068R.string.quotes44, C1068R.string.quotes45, C1068R.string.quotes46, C1068R.string.quotes47, C1068R.string.quotes48, C1068R.string.quotes49, C1068R.string.quotes50, C1068R.string.quotes51, C1068R.string.quotes52, C1068R.string.quotes53, C1068R.string.quotes54, C1068R.string.quotes55, C1068R.string.quotes56, C1068R.string.quotes57, C1068R.string.quotes58, C1068R.string.quotes59, C1068R.string.quotes60, C1068R.string.quotes61, C1068R.string.quotes62, C1068R.string.quotes63, C1068R.string.quotes64, C1068R.string.quotes65, C1068R.string.quotes66, C1068R.string.quotes67, C1068R.string.quotes68, C1068R.string.quotes69, C1068R.string.quotes70, C1068R.string.quotes71, C1068R.string.quotes72, C1068R.string.quotes73, C1068R.string.quotes74, C1068R.string.quotes75, C1068R.string.quotes76, C1068R.string.quotes77, C1068R.string.quotes78, C1068R.string.quotes79, C1068R.string.quotes80, C1068R.string.quotes81, C1068R.string.quotes82, C1068R.string.quotes83, C1068R.string.quotes84, C1068R.string.quotes85, C1068R.string.quotes86, C1068R.string.quotes87, C1068R.string.quotes88, C1068R.string.quotes89, C1068R.string.quotes90, C1068R.string.quotes91, C1068R.string.quotes92, C1068R.string.quotes93, C1068R.string.quotes94, C1068R.string.quotes95, C1068R.string.quotes96, C1068R.string.quotes97, C1068R.string.quotes98, C1068R.string.quotes99, C1068R.string.quotes100, C1068R.string.quotes101, C1068R.string.quotes102, C1068R.string.quotes103, C1068R.string.quotes104, C1068R.string.quotes105, C1068R.string.quotes106, C1068R.string.quotes107, C1068R.string.quotes108, C1068R.string.quotes109, C1068R.string.quotes110, C1068R.string.quotes111, C1068R.string.quotes112, C1068R.string.quotes113, C1068R.string.quotes114, C1068R.string.quotes115, C1068R.string.quotes116, C1068R.string.quotes117, C1068R.string.quotes118, C1068R.string.quotes119, C1068R.string.quotes120, C1068R.string.quotes121, C1068R.string.quotes122, C1068R.string.quotes123, C1068R.string.quotes124, C1068R.string.quotes125, C1068R.string.quotes126, C1068R.string.quotes127, C1068R.string.quotes128, C1068R.string.quotes129, C1068R.string.quotes130, C1068R.string.quotes131, C1068R.string.quotes132, C1068R.string.quotes133, C1068R.string.quotes134, C1068R.string.quotes135, C1068R.string.quotes136, C1068R.string.quotes137, C1068R.string.quotes138, C1068R.string.quotes139, C1068R.string.quotes140, C1068R.string.quotes141, C1068R.string.quotes142, C1068R.string.quotes143, C1068R.string.quotes144, C1068R.string.quotes145, C1068R.string.quotes146, C1068R.string.quotes147, C1068R.string.quotes148, C1068R.string.quotes149, C1068R.string.quotes150, C1068R.string.quotes151, C1068R.string.quotes152, C1068R.string.quotes153, C1068R.string.quotes154, C1068R.string.quotes155, C1068R.string.quotes156, C1068R.string.quotes157, C1068R.string.quotes158, C1068R.string.quotes159, C1068R.string.quotes160, C1068R.string.quotes161, C1068R.string.quotes162, C1068R.string.quotes163, C1068R.string.quotes164, C1068R.string.quotes165, C1068R.string.quotes166, C1068R.string.quotes167, C1068R.string.quotes168, C1068R.string.quotes169, C1068R.string.quotes170, C1068R.string.quotes171, C1068R.string.quotes172, C1068R.string.quotes173, C1068R.string.quotes174, C1068R.string.quotes175, C1068R.string.quotes176, C1068R.string.quotes177, C1068R.string.quotes178, C1068R.string.quotes179, C1068R.string.quotes180, C1068R.string.quotes181, C1068R.string.quotes182, C1068R.string.quotes183, C1068R.string.quotes184, C1068R.string.quotes185, C1068R.string.quotes186, C1068R.string.quotes187, C1068R.string.quotes188, C1068R.string.quotes189, C1068R.string.quotes190, C1068R.string.quotes191, C1068R.string.quotes192, C1068R.string.quotes193, C1068R.string.quotes194, C1068R.string.quotes195, C1068R.string.quotes196, C1068R.string.quotes197, C1068R.string.quotes198, C1068R.string.quotes199, C1068R.string.quotes200, C1068R.string.quotes201, C1068R.string.quotes202, C1068R.string.quotes203, C1068R.string.quotes204, C1068R.string.quotes205, C1068R.string.quotes206, C1068R.string.quotes207, C1068R.string.quotes208, C1068R.string.quotes209, C1068R.string.quotes210, C1068R.string.quotes211, C1068R.string.quotes212, C1068R.string.quotes213, C1068R.string.quotes214, C1068R.string.quotes215, C1068R.string.quotes216, C1068R.string.quotes217, C1068R.string.quotes218, C1068R.string.quotes219, C1068R.string.quotes220, C1068R.string.quotes221, C1068R.string.quotes222, C1068R.string.quotes223, C1068R.string.quotes224, C1068R.string.quotes225, C1068R.string.quotes226, C1068R.string.quotes227, C1068R.string.quotes228, C1068R.string.quotes229, C1068R.string.quotes230, C1068R.string.quotes231, C1068R.string.quotes232, C1068R.string.quotes233, C1068R.string.quotes234, C1068R.string.quotes235, C1068R.string.quotes236, C1068R.string.quotes237, C1068R.string.quotes238, C1068R.string.quotes239, C1068R.string.quotes240, C1068R.string.quotes241, C1068R.string.quotes242, C1068R.string.quotes243, C1068R.string.quotes244, C1068R.string.quotes245, C1068R.string.quotes246, C1068R.string.quotes247, C1068R.string.quotes248, C1068R.string.quotes249, C1068R.string.quotes250, C1068R.string.quotes251, C1068R.string.quotes252, C1068R.string.quotes253, C1068R.string.quotes254, C1068R.string.quotes255, C1068R.string.quotes256, C1068R.string.quotes257, C1068R.string.quotes258, C1068R.string.quotes259, C1068R.string.quotes260, C1068R.string.quotes261, C1068R.string.quotes262, C1068R.string.quotes263, C1068R.string.quotes264, C1068R.string.quotes265, C1068R.string.quotes266, C1068R.string.quotes267, C1068R.string.quotes268, C1068R.string.quotes269, C1068R.string.quotes270, C1068R.string.quotes271, C1068R.string.quotes272, C1068R.string.quotes273, C1068R.string.quotes274, C1068R.string.quotes275, C1068R.string.quotes276, C1068R.string.quotes277, C1068R.string.quotes278, C1068R.string.quotes279, C1068R.string.quotes280, C1068R.string.quotes281, C1068R.string.quotes282, C1068R.string.quotes283, C1068R.string.quotes284, C1068R.string.quotes285, C1068R.string.quotes286, C1068R.string.quotes287, C1068R.string.quotes288, C1068R.string.quotes289, C1068R.string.quotes290, C1068R.string.quotes291, C1068R.string.quotes292, C1068R.string.quotes293, C1068R.string.quotes294, C1068R.string.quotes295, C1068R.string.quotes296, C1068R.string.quotes297, C1068R.string.quotes298, C1068R.string.quotes299, C1068R.string.quotes300, C1068R.string.quotes301, C1068R.string.quotes302, C1068R.string.quotes303, C1068R.string.quotes304, C1068R.string.quotes305, C1068R.string.quotes306, C1068R.string.quotes307, C1068R.string.quotes308, C1068R.string.quotes309, C1068R.string.quotes310, C1068R.string.quotes311, C1068R.string.quotes312, C1068R.string.quotes313, C1068R.string.quotes314, C1068R.string.quotes315, C1068R.string.quotes316, C1068R.string.quotes317, C1068R.string.quotes318, C1068R.string.quotes319, C1068R.string.quotes320, C1068R.string.quotes321, C1068R.string.quotes322, C1068R.string.quotes323, C1068R.string.quotes324, C1068R.string.quotes325, C1068R.string.quotes326, C1068R.string.quotes327, C1068R.string.quotes328, C1068R.string.quotes329, C1068R.string.quotes330, C1068R.string.quotes331, C1068R.string.quotes332, C1068R.string.quotes333, C1068R.string.quotes334, C1068R.string.quotes335, C1068R.string.quotes336, C1068R.string.quotes337, C1068R.string.quotes338, C1068R.string.quotes339, C1068R.string.quotes340, C1068R.string.quotes341, C1068R.string.quotes342, C1068R.string.quotes343, C1068R.string.quotes344, C1068R.string.quotes345, C1068R.string.quotes346, C1068R.string.quotes347, C1068R.string.quotes348, C1068R.string.quotes349, C1068R.string.quotes350, C1068R.string.quotes351, C1068R.string.quotes352, C1068R.string.quotes353, C1068R.string.quotes354, C1068R.string.quotes355, C1068R.string.quotes356, C1068R.string.quotes357, C1068R.string.quotes358, C1068R.string.quotes359, C1068R.string.quotes360, C1068R.string.quotes361, C1068R.string.quotes362, C1068R.string.quotes363, C1068R.string.quotes364, C1068R.string.quotes365, C1068R.string.quotes366, C1068R.string.quotes367};
    TextFragmentListener textFragmentListener;

    public interface TextFragmentListener {
        void onText(String str);
    }

    public void setTextListener(TextFragmentListener textFragmentListener2) {
        this.textFragmentListener = textFragmentListener2;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ((FragmentActivity) Objects.requireNonNull(getActivity())).getWindow().setSoftInputMode(32);
        View inflate = layoutInflater.inflate(C1068R.layout.fragment_text_editor, viewGroup, false);
        inflate.findViewById(R.id.btnCancel).setOnClickListener(this);
        inflate.findViewById(C1068R.C1070id.btnDone).setOnClickListener(this);
        this.editText = (EditText) inflate.findViewById(C1068R.C1070id.edtQuotes);
        inflate.findViewById(C1068R.C1070id.btnRandom).setOnClickListener(this);
        inflate.findViewById(C1068R.C1070id.btnMoreQuotes).setOnClickListener(this);
        if (getArguments() != null) {
            this.editText.setText(getArguments().getString("edittext"));
        }
        new CrazyShadow.Builder().setContext(getActivity()).setDirection(64).setShadowRadius(30.0f).setCorner(30.0f).setImpl(CrazyShadow.IMPL_DRAW).action(inflate.findViewById(C1068R.C1070id.edtQuotes));
        if (this.editText.requestFocus()) {
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    TextEditorFragment.this.lambda$onCreateView$0$TextEditorFragment();
                }
            }, 200);
        }
        return inflate;
    }

    public /* synthetic */ void lambda$onCreateView$0$TextEditorFragment() {
        ((InputMethodManager) getActivity().getSystemService("input_method")).showSoftInput(this.editText, 1);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case C1068R.C1070id.btnCancel:
                this.editText.setText("");
                return;
            case C1068R.C1070id.btnDone:
                String obj = this.editText.getText().toString();
                TextFragmentListener textFragmentListener2 = this.textFragmentListener;
                if (textFragmentListener2 != null) {
                    textFragmentListener2.onText(obj);
                    ((FragmentActivity) Objects.requireNonNull(getActivity())).getSupportFragmentManager().popBackStack((String) null, 1);
                    View currentFocus = getActivity().getCurrentFocus();
                    if (currentFocus != null) {
                        ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
                        return;
                    }
                    return;
                }
                return;
            case C1068R.C1070id.btnMoreQuotes:
                QuotesFragment quotesFragment = new QuotesFragment();
                quotesFragment.setQuotesListener(this);
                ((FragmentActivity) Objects.requireNonNull(getActivity())).getSupportFragmentManager().beginTransaction().setCustomAnimations(C1068R.anim.enter_from_right, C1068R.anim.exit_to_left, C1068R.anim.enter_from_left, C1068R.anim.exit_to_right).add(C1068R.C1070id.frameLayoutEditMai, quotesFragment, "QUOTES").addToBackStack("QUOTES").commit();
                View currentFocus2 = getActivity().getCurrentFocus();
                if (currentFocus2 != null) {
                    ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(currentFocus2.getWindowToken(), 0);
                    return;
                }
                return;
            case C1068R.C1070id.btnRandom:
                this.editText.setText(this.quotes[new Random().nextInt(this.quotes.length)]);
                return;
            default:
                return;
        }
    }

    public void onQuotes(int i) {
        this.editText.setText(i);
    }
}
