package com.lxc.paser;

import com.lxc.ChannelTransRecord;
import com.lxc.RuleMap;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * Created By lxc
 * Date: 2017/12/19
 */
public class ReadLineParser extends AbstractParser {

    public ReadLineParser(List<RuleMap> ruleMapList, String filePath, String encode) {
        super(ruleMapList, filePath, encode);
    }

    @Override
    public List<ChannelTransRecord> parse() {
        int lineRows = 0;
        try {
            LineIterator iterator = FileUtils.lineIterator(new File(filePath), encode);
            while (iterator.hasNext()) {
                String line = iterator.nextLine();
                lineRows++;
                if (skipRows > 0) {
                    skipRows--;
                    continue;
                }
                ChannelTransRecord tmp = new ChannelTransRecord();
                setFields(tmp, line, ruleMapList, specialRules);
                list.add(tmp);
            }
        } catch (FileNotFoundException fe) {
            throw new RuntimeException("文件不存在");
        } catch (Exception e) {
            throw new RuntimeException("解析文件报错");
        } finally {
        }
        return list;
    }
}
