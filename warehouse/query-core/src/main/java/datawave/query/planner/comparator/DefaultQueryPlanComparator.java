package datawave.query.planner.comparator;

import datawave.query.planner.QueryPlan;
import org.apache.accumulo.core.data.Range;
import org.apache.hadoop.io.Text;

import java.util.Comparator;

/**
 * Sorts QueryPlan objects according to their shard id (i.e. starting row)
 */
public class DefaultQueryPlanComparator implements Comparator<QueryPlan> {
    @Override
    public int compare(QueryPlan o1, QueryPlan o2) {
        return o1.getRanges().iterator().next().getStartKey().getRow().compareTo(o2.getRanges().iterator().next().getStartKey().getRow());
    }
}
