package datawave.query.planner.comparator;

import datawave.query.jexl.visitors.GeoWaveQueryInfoVisitor;
import datawave.query.planner.QueryPlan;

import java.util.Collection;
import java.util.Comparator;

/**
 * Sorts QueryPlan objects according to the GeoWave terms
 */
public class GeoWaveQueryPlanComparator implements Comparator<QueryPlan> {
    
    final private GeoWaveQueryInfoVisitor geoWaveVisitor;
    
    public GeoWaveQueryPlanComparator(Collection<String> geoFields) {
        geoWaveVisitor = new GeoWaveQueryInfoVisitor(geoFields);
    }
    
    @Override
    public int compare(QueryPlan o1, QueryPlan o2) {
        return geoWaveVisitor.parseGeoWaveQueryInfo(o1.getQueryTree()).compareTo(geoWaveVisitor.parseGeoWaveQueryInfo(o2.getQueryTree()));
    }
}
