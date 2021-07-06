package com.interview.tesco.api;


import com.interview.tesco.api.exceptions.ColleagueNotFoundExceptions;
import com.interview.tesco.api.exceptions.NoDepartmentAssociatedException;
import com.interview.tesco.api.model.Colleague;
import com.interview.tesco.api.model.Department;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TU_FetchShiftDetailsImp {

    private FetchShiftDetails fetchShiftDetails;

    @Before
    public void initTest() {
        fetchShiftDetails = new FetchShiftDetailsImp(buildColleagueData());
    }

    @Test
    public void testFindColleague() throws ColleagueNotFoundExceptions {
        Colleague colleague = new Colleague("Abhijit");
        Colleague result = fetchShiftDetails.findColleague(colleague);
        Assert.assertTrue(result.getName().equals(colleague.getName()));
    }

    @Test(expected = ColleagueNotFoundExceptions.class)
    public void testFindColleagueWithException() throws ColleagueNotFoundExceptions {
        Colleague colleague = new Colleague("Arun");
        fetchShiftDetails.findColleague(colleague);
    }

    @Test
    public void testGetShiftTimingsForColleague() throws NoDepartmentAssociatedException {
        Colleague searchColleauge = new Colleague("Abhijit");
        searchColleauge.addDepartmentList(Department.CHECKOUT);
        searchColleauge.addDepartmentList(Department.CHECKOUT1);
        searchColleauge.addDepartmentList(Department.BAKERY);
        searchColleauge.addDepartmentList(Department.DAIRY);
        List<Integer> shiftTimings = fetchShiftDetails.getShiftTimingsForColleague(searchColleauge);
        Assert.assertTrue(shiftTimings.size() == 4);
    }

    @Test(expected = NoDepartmentAssociatedException.class)
    public void testGetShiftTimingsForColleagueWithException() throws NoDepartmentAssociatedException {
        Colleague searchColleauge = new Colleague("Abhijit");
        fetchShiftDetails.getShiftTimingsForColleague(searchColleauge);
    }

    private List<Colleague> buildColleagueData() {
        Colleague colleague = new Colleague("Abhijit");
        colleague.addDepartmentList(Department.BAKERY);
        colleague.addDepartmentList(Department.CHECKOUT);
        colleague.addDepartmentList(Department.CHECKOUT1);
        colleague.addDepartmentList(Department.DAIRY);
        return Arrays.asList(colleague);
    }
}
