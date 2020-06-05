package Configuration;

public class Config {
    
    class GetDateTimeFeature {
        String FeatureTag;
    }

    class GetTimeFeature {
        String FeatureTag;
    }

    class GetDateFeature {
        String FeatureTag;
    }

    class TimeCache {
        String FeatureTag = "SPEC-117";
    }

    class SystemTime{
        String[] FeatureTag = {
            "SPEC-116",
            "SPEC-118"
        };
    }
}