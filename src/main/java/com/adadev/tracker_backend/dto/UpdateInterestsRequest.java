package com.adadev.tracker_backend.dto;

import java.util.Set;

public class UpdateInterestsRequest {
    private Set<String> interests;
    public UpdateInterestsRequest() { // Need no argument constructor
    }

    public UpdateInterestsRequest(Set<String> interests) {
            this.interests = interests;
    }

    public Set<String> getInterests () {
        return this.interests;
    }


}
