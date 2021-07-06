package com.interview.tesco.api;

import com.interview.tesco.api.exceptions.ColleagueNotFoundExceptions;
import com.interview.tesco.api.exceptions.NoDepartmentAssociatedException;
import com.interview.tesco.api.model.Colleague;

import java.util.List;

public interface FetchShiftDetails {

    Colleague findColleague(Colleague colleague) throws ColleagueNotFoundExceptions;

    List<Integer> getShiftTimingsForColleague(Colleague colleague) throws NoDepartmentAssociatedException;
}
