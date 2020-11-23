package org.nr.tour.util;

import org.nr.tour.domain.Member;
import org.springframework.util.StringUtils;

/**
 * @author Wujun
 */
public class MemberUtils {

    public static boolean isGuestMember(Member member) {
        return StringUtils.isEmpty(member.getMobilePhone());
    }

}
