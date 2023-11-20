function solution(today, terms, privacies) {
    date = today.split(".");
    year = date[0];
    month = date[1];
    day = date[2];

    let answer = [];
    var index = 0;

    privacies.forEach((privacy) => {
        index++;
        const expireInfo = privacy.split(" ");
        const expireDate = expireInfo[0].split(".");
        const monthsBetweenDates =
            (year - expireDate[0]) * 12 * 28 + (month - expireDate[1]) * 28 + (day - expireDate[2]);

        const termInfo = terms.find((item) => item.includes(expireInfo[1]));
        const term = termInfo.split(" ")[1] * 28;

        if (monthsBetweenDates >= term) {
            answer.push(index);
        }
    });

    return answer;
}

/*
ChatGPT 리팩토링

function solution(today, terms, privacies) {
  const [todayYear, todayMonth, todayDay] = today.split(".").map(Number);
  const termsMap = new Map(terms.map(term => term.split(" ")));

  return privacies
    .map((privacy, index) => {
      const [expireDate, type] = privacy.split(" ");
      const [expireYear, expireMonth, expireDay] = expireDate.split(".").map(Number);
      const termMonths = termsMap.get(type) * 28;

      const monthsBetweenDates =
        (todayYear - expireYear) * 12 * 28 +
        (todayMonth - expireMonth) * 28 +
        (todayDay - expireDay);

      return monthsBetweenDates >= termMonths ? index + 1 : null;
    })
    .filter(index => index !== null);
}

map과 filter를 적절히 사용하여 원하는 결과를 빠르게 얻어내는 방법을 알게되었다.
TODO : map()의 사용 방법에 대해 공부하여 정리
 */
