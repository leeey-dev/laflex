package leeey.project.lotto.util


import spock.lang.Specification

class LottoHistoryUtilTest extends Specification {

    def "getHistories"() {

        when:
        def histories = HistoryUtil.getHistories()

        then:
        histories.size() == 1086
    }
}