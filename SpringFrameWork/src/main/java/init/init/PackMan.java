package init.init;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import static init.init.GamingBasic.FONT_WHITE;
import static init.init.GamingBasic.RESET;

@Component
@Primary
public class PackMan implements Console {

    private static final Log LOG = LogFactory.getLog(PackMan.class);

    //up function
    public void up() {
        LOG.info(FONT_WHITE + "North direction" + RESET);
    }

    //down function
    public void down() {
        LOG.info(FONT_WHITE + "South direction" + RESET);
    }

    //left function
    public void left() {
        LOG.info(FONT_WHITE + "West direction" + RESET);
    }

    //right function
    public void right() {
        LOG.info(FONT_WHITE + "East direction" + RESET);
    }
}
