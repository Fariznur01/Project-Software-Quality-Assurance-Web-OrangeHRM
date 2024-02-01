import http from 'k6/http';
import { sleep } from 'k6';

export const options = {
  vus: 20,
  duration: '1h',
};

export default function () {
  const res = http.get('https://opensource-demo.orangehrmlive.com');
  sleep(2);

  // Assertion
  if (res.status !== 200) {
    console.error(`Unexpected status code: ${res.status}`);
  }
}
