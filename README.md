# CPT208_human_centric_computing
Gemini said
这是一份为你量身打造的 README.md 模板。它的排版非常清爽，使用了 Emoji 来增强视觉引导，不仅能让你们的老师和同学一秒钟看懂，还能显得整个项目非常专业和成熟。

你可以直接复制下面的所有内容，粘贴到你们 GitHub 仓库根目录下的 README.md 文件中。

🏃‍♂️ Geo-PolyRun (定点圈地战)
“让每一次枯燥的跑步，都成为一场现实版的策略地盘战。”

💡 项目简介 (What is this?)
Geo-PolyRun 是一款专为校园跑者设计的 Web App 游戏。我们抛弃了传统跑步软件中让人焦虑的“配速”和“公里数”，将真实的校园环境（如 XJTLU 南校区）变成了一个巨大的、网格化的赛博棋盘。

玩家分为不同阵营，用真实的奔跑去抢占物理节点，再用聪明的策略将节点连线圈地。最终，圈出多边形总面积最大的队伍将赢得比赛，并获得专属的 AR 实景神兽奖励！

🎮 核心玩法 (How to Play?)
我们首创了 “动静分离 (Action-Strategy Loop)” 的交互机制，彻底解决边跑边玩手机的安全隐患：

🏁 上半场：拼体力抢点 (Run & Capture)
寻找节点： 打开手机地图，寻找周围的“据点”。

长按占领： 跑进据点 15 米范围内，在屏幕上长按 3 秒充能即可占领该点。

黄金盲盒： 留意突发的“限时黄金节点”，抢到即可让该区域面积翻倍！（触发你的高燃脂间歇性冲刺）。

🧠 下半场：拼智力连线 (Connect & Rule)
赛后集结： 跑步倒计时结束，同队玩家聚在一起进入“策略连线板”。

拖拽连线： 用手指将本队抢到的点连成闭合的多边形。

无限叠加策略： 我们允许己方图形重叠（大圈套小圈），也允许敌我地盘互相穿插。跑得不远？没关系！在局部高密度折返跑，疯狂画圈叠加面积，一样能为团队狂砍分数！

🏆 终局：AR 炫耀 (XR Settlement)
获胜队伍将获得专属实体书签。用 Web App 扫描该书签，一只巨大的 全息 AR 神兽 将在你们刚刚征服的实景领地上空咆哮而出，供大家合影留念！

🛠️ 技术架构 (Tech Stack)
本项目完全基于 Web 端开发，即开即用，主打轻量与稳定：

核心交互 & 界面： HTML5 / CSS3 / JavaScript

定位服务： HTML5 Geolocation API (仅定点触发，不依赖耗电的连续轨迹追踪)

复杂多边形计算： Turf.js (防自交检测算法、多边形面积瞬间求和)

增强现实结算： AR.js (Marker-based WebXR，实现零 Bug 的实体与虚拟交互)

👥 团队信息 (Meet the Team)
本项目由 XJTLU CPT208 (人机计算) 课程 C1-3 小组 设计与开发：

Xinling Du - Product Manager & HCI Lead

Zairan Shi - Lead Developer

Lingyu Wang - UI/UX Designer

Peilin Liu - XR & Interactive Specialist

Developed with ❤️ and 🏃‍♂️💨 for CPT208 Playful Experience Design.
