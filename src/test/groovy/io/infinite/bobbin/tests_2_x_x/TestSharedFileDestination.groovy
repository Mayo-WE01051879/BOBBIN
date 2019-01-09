package io.infinite.bobbin.tests_2_x_x

import io.infinite.bobbin.BobbinConfig
import io.infinite.bobbin.destinations.SharedFileDestination

class TestSharedFileDestination extends SharedFileDestination {

    static TestSharedFileDestination instance

    TestSharedFileDestination(BobbinConfig.Destination destinationConfig, BobbinConfig parentBobbinConfig) {
        super(destinationConfig, parentBobbinConfig)
        instance = this
    }
}