package com.mytests.spring.springwebplacehodersinurls;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// the paths are shown incorrectly in case of property placeholder with prefix - https://youtrack.jetbrains.com/issue/IDEA-296582
// false-positive errors - https://youtrack.jetbrains.com/issue/IDEA-296629

// my.base.url = '/foo/bar'
// some.url = '/buzz'
@RestController
@RequestMapping("/test${my.base.url}")
public class MyControllerWithTopLevelPlaceHolderWithPrefixes {

    // false-positive: "path variable 'my' is not consumed"
    @GetMapping("/m1")  // /test/foo/bar/m1
    public String m1()
    {
        return "endpoint with property placeholder with prefix, coming from controller-level mapping";
    }

    // false-positive: "path variable 'my' is not consumed, path variable 'some' is not consumed"
    @GetMapping("/m2${some.url}") //  /test/foo/bar/m2/buzz
    public String m2() {
        return "endpoint with 2 property placeholders both with prefixes";
    }
}
