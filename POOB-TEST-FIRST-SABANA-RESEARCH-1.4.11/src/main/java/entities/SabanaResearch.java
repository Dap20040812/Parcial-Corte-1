package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SabanaResearch {

    private List<Group> groups;
    private List<Summary> summaries;

    public SabanaResearch(List<Group> groups) {
        this.groups = groups;
        this.summaries = new ArrayList<>();
    }

    public int countOfGroups() {
        return this.groups.size();
    }

    public int countOfSummaries() {
        return this.summaries.size();
    }

    public void addSummary(Summary summary){this.summaries.add(summary);}

    /**
     * Create a summary entry in the current date.
     * - Calculate the count of active projects.
     *
     * @return The new Summary entry.
     */
    public Summary createSummaryEntry() {
        int ap=0;

        for(Group g: this.groups)
        {
            ap=ap+g.countActiveProjects();
        }
        Summary s = new Summary(ap,LocalDate.now());
        addSummary(s);
        return s;
    }
}
