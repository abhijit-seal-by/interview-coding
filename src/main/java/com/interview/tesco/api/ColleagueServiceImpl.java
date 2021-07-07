package com.interview.tesco.api;

import com.interview.tesco.api.exceptions.ColleagueNotFoundExceptions;
import com.interview.tesco.api.exceptions.NoDepartmentAssociatedException;
import com.interview.tesco.api.model.Colleague;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ColleagueServiceImpl implements ColleagueService {

    List<Colleague> colleagues;

    public ColleagueServiceImpl(List<Colleague> colleagues) {
        this.colleagues = colleagues;
    }

    @Override
    public Colleague findColleague(Colleague colleague) throws ColleagueNotFoundExceptions {
        List<Colleague> filteredRecord = colleagues.stream().filter(colleague1 -> {
            return colleague.getName().equals(colleague1.getName());
        }).collect(Collectors.toList());

        if(filteredRecord.size() == 0) {
            throw new ColleagueNotFoundExceptions("No Colleague found with name : " + colleague.getName());
        }

        return filteredRecord.get(0);
    }

    @Override
    public List<Integer> getShiftTimingsForColleague(Colleague colleague) throws NoDepartmentAssociatedException {
        List<Integer> timings = new ArrayList<>();
        if(colleague.getDepartmentList().size() == 0) {
            throw new NoDepartmentAssociatedException("No department config");
        }
        final int previousEndTime[] = {0};
        colleague.getDepartmentList().forEach(
                department ->  {
                    if(department.getStartTime() <= previousEndTime[0]) {
                        //timings.remove(new Integer(department.getStartTime()));
                        timings.remove(new Integer(previousEndTime[0]));
                    }
                    else {
                        timings.add(department.getStartTime());
                    }
                    previousEndTime[0] = department.getEndTime();
                    timings.add(department.getEndTime());
                }
        );
        return timings;
    }
}
