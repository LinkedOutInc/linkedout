import React from "react";

const copypastas = [
  "What the heck did you just say about me, you little jerk? I'll have you know I graduated top of my class in the Navy Seals, and I've been involved in numerous secret raids on Al-Quaeda, and I have over 300 confirmed kills. I am trained in guerrilla warfare and I'm the top sniper in the entire US armed forces. You are nothing to me but just another target. I will wipe you out with precision the likes of which has never been seen before on this Earth, mark my words. You think you can get away with saying that stuff to me over the Internet? Think again, pal. As we speak I am contacting my secret network of spies across the USA and your IP is being traced right now so you better prepare for the storm, buddy. The storm that wipes out the pathetic little thing you call your life. You're done, kid. I can be anywhere, anytime, and I can defeat you in over seven hundred ways, and that's just with my bare hands. Not only am I extensively trained in unarmed combat, but I have access to the entire arsenal of the United States Marine Corps and I will use it to its full extent to wipe your miserable behind off the face of the continent, you little brat. If only you could have known what consequences your little \"clever\" comment was about to bring down upon you, maybe you would have held your tongue. But you couldn't, you didn't, and now you're paying the price, you silly person. I will bring down fury upon you and you will regret it. You're done, kiddo.",
  "Today when I walked into my economics class I saw something I dread every time I close my eyes. Someone had brought their new gaming laptop to class. The Forklift he used to bring it was still running idle at the back. I started sweating as I sat down and gazed over at the 700lb beast that was his laptop. He had already reinforced his desk with steel support beams and was in the process of finding an outlet for a power cable thicker than Amy Schumer's thigh. I start shaking. I keep telling myself I'm going to be alright and that there's nothing to worry about. He somehow finds a fricking outlet. Tears are running down my cheeks as I send my last texts to my family saying I love them. The teacher starts the lecture, and the student turns his laptop on. The colored lights on his RGB Backlit keyboard flare to life like a nuclear flash, and a deep humming fills my ears and shakes my very soul. The entire city power grid goes dark. The classroom begins to shake as the massive fans begin to spin. In mere seconds my world has gone from vibrant life, to a dark, earth shattering void where my body is getting torn apart by the 150mph gale force winds and the 500 decibel groan of the cooling fans. As my body finally surrenders, I weep, as my school and my city go under. I fricking hate gaming laptops.",
  'I have noticed that, although this website has 481k users, I am not receiving 481k likes on my posts. I\'m not sure if this is being done intentionally or if these "connections" are forgetting to click "like". Either way, I\'ve had enough. I have compiled a spreadsheet of individuals who have "forgotten" to like my most recent posts. After 2 consecutive strikes, your name is automatically highlighted (shown in red) and I am immediately notified. 3 consecutive strikes and you can expect an in-person "consultation". Think about your actions.',
  'Hello am 48 year old man from somalia. sorry for bed england. i selled my wife for internet connection for play "conter stirk" and i want to become the goodest player like you I play with 400 ping on brazil server and i am Global elite 2. pls no copy pasterino my story.',
];

const randomCopypasta = () => {
  return copypastas[Math.floor(Math.random() * copypastas.length)];
};

function NotFound() {
  const copypasta = randomCopypasta();

  return (
    <div className="max-w-screen-xl w-screen mx-auto mt-4 flex items-center justify-center">
      <div className="p-8 rounded-lg text-center space-y-4">
        <h1 className="text-4xl font-bold">404</h1>
        <p className="text-xl">We don't know how, but you found this:</p>
        <div className="text-lg text-gray-500">{copypasta}</div>
      </div>
    </div>
  );
}

export default NotFound;
