package footballsim.logging;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/*
    Taken 10/01-2022 from: https://stackoverflow.com/questions/53211694/change-color-and-format-of-java-util-logging-logger-output-in-eclipse
*/

/**
 * LogFormatter.
 * Formats text to the console.
 */
public class LogFormatter extends Formatter {
    // Holds a refrence to a color changed by the logger class
    private LogColorRefrence m_ColorRefrence = new LogColorRefrence();

    public void setColorRefrence(final LogColorRefrence colorRefrence) {
        m_ColorRefrence = colorRefrence;
    }

    @Override
    public String format(LogRecord record)
    {
        StringBuilder builder = new StringBuilder();
        builder.append(m_ColorRefrence.getColor());

        builder.append("[");
        builder.append(calcDate(record.getMillis()));
        builder.append("]");

        builder.append(" [");
        builder.append(record.getSourceClassName());
        builder.append("]");

        builder.append(" [");
        builder.append(record.getLevel().getName());
        builder.append("]");

        builder.append(LogColor.ANSI_WHITE);
        builder.append(" - ");
        builder.append(record.getMessage());

        Object[] params = record.getParameters();

        if (params != null)
        {
            builder.append("\t");
            for (int i = 0; i < params.length; i++)
            {
                builder.append(params[i]);
                if (i < params.length - 1)
                    builder.append(", ");
            }
        }

        builder.append(LogColor.ANSI_RESET);
        builder.append("\n");
        return builder.toString();
    }

    private String calcDate(long millisecs) {
        SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date resultdate = new Date(millisecs);
        return date_format.format(resultdate);
    }
}
