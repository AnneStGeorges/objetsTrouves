package com.anne.ExoAppli.model;

import com.anne.ExoAppli.R;

import androidx.annotation.StringRes;

public enum CivilityEnum {

    MR(R.string.civility_mr),
    MRS(R.string.civility_mrs);

    private int resourceId;

    CivilityEnum(@StringRes int stringRes) {
        this.resourceId = stringRes;
    }

    public int getResourceId() {
        return resourceId;
    }
}
