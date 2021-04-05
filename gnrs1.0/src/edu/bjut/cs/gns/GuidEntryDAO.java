package edu.bjut.cs.gns;

import java.util.List;

public interface GuidEntryDAO {

    void addGuidEntry(GuidEntry guidEntry);

    void deleteGuidEntry(String guid);

    List<GuidEntry> getAllGuidEntry();

    GuidEntry getGuidEntry(String guid);

}
