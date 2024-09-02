package com.codeartify.exercise7;

import java.util.Optional;

public interface FetchConcertVisitor {
    Optional<ConcertVisitor> fetchById(int concertVisitorId);
}
